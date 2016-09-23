/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.theme.cts;

import com.android.ddmlib.Log;
import com.android.ddmlib.Log.LogLevel;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.util.concurrent.Callable;

import javax.imageio.ImageIO;

/**
 * Compares the images generated by the device with the reference images.
 */
public class ComparisonTask implements Callable<File> {
    private static final String TAG = "ComparisonTask";

    private static final int IMAGE_THRESHOLD = 2;

    /** Maximum allowable number of consecutive failed pixels. */
    private static final int MAX_CONSECUTIVE_FAILURES = 1;

    private final File mExpected;
    private final File mActual;

    public ComparisonTask(File expected, File actual) {
        mExpected = expected;
        mActual = actual;
    }

    public File call() {
        try {
            final BufferedImage expected = ImageIO.read(mExpected);
            final BufferedImage actual = ImageIO.read(mActual);
            if (!compare(expected, actual, IMAGE_THRESHOLD)) {
                final File diff = File.createTempFile("diff_" + mExpected.getName(), ".png");
                createDiff(expected, actual, diff);
                return diff;
            }
        } catch (IOException e) {
            Log.logAndDisplay(LogLevel.ERROR, TAG, e.toString());
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Verifies that the pixels of reference and generated images are similar
     * within a specified threshold.
     *
     * @param expected expected image
     * @param actual actual image
     * @param threshold maximum difference per channel
     * @return {@code true} if the images are similar, false otherwise
     */
    private static int getAlphaScaledBlue(final int color) {
        return (color & 0x000000FF) * getAlpha(color) / 255;
    }

    private static int getAlphaScaledGreen(final int color) {
        return ((color & 0x0000FF00) >> 8) * getAlpha(color) / 255;
    }

    private static int getAlphaScaledRed(final int color) {
        return ((color & 0x00FF0000) >> 16) * getAlpha(color) / 255;
    }

    private static int getAlpha(final int color) {
        // use logical shift for keeping an unsigned value
        return (color & 0xFF000000) >>> 24;
    }

    private static boolean compare(BufferedImage reference, BufferedImage generated, int threshold) {
        final int w = generated.getWidth();
        final int h = generated.getHeight();
        if (w != reference.getWidth() || h != reference.getHeight()) {
            return false;
        }

        for (int i = 0; i < w; i++) {
            int consecutive = 0;

            for (int j = 0; j < h; j++) {
                final int p1 = reference.getRGB(i, j);
                final int p2 = generated.getRGB(i, j);

                final int dr = getAlphaScaledRed(p1) - getAlphaScaledRed(p2);
                final int dg = getAlphaScaledGreen(p1) - getAlphaScaledGreen(p2);
                final int db = getAlphaScaledBlue(p1) - getAlphaScaledBlue(p2);

                if (Math.abs(db) > threshold ||
                        Math.abs(dg) > threshold ||
                        Math.abs(dr) > threshold) {
                    consecutive++;

                    if (consecutive > MAX_CONSECUTIVE_FAILURES) {
                        return false;
                    }
                } else {
                    consecutive = 0;
                }
            }
        }
        return true;
    }

    private static void createDiff(BufferedImage expected, BufferedImage actual, File out)
            throws IOException {
        final int w1 = expected.getWidth();
        final int h1 = expected.getHeight();
        final int w2 = actual.getWidth();
        final int h2 = actual.getHeight();
        final int width = Math.max(w1, w2);
        final int height = Math.max(h1, h2);

        // The diff will contain image1, image2 and the difference between the two.
        final BufferedImage diff = new BufferedImage(
                width * 3, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                final boolean inBounds1 = i < w1 && j < h1;
                final boolean inBounds2 = i < w2 && j < h2;
                int colorExpected = Color.WHITE.getRGB();
                int colorActual = Color.WHITE.getRGB();
                int colorDiff;
                if (inBounds1 && inBounds2) {
                    colorExpected = expected.getRGB(i, j);
                    colorActual = actual.getRGB(i, j);
                    colorDiff = colorExpected == colorActual ? colorExpected : Color.RED.getRGB();
                } else if (inBounds1 && !inBounds2) {
                    colorExpected = expected.getRGB(i, j);
                    colorDiff = Color.BLUE.getRGB();
                } else if (!inBounds1 && inBounds2) {
                    colorActual = actual.getRGB(i, j);
                    colorDiff = Color.GREEN.getRGB();
                } else {
                    colorDiff = Color.MAGENTA.getRGB();
                }

                int x = i;
                diff.setRGB(x, j, colorExpected);
                x += width;
                diff.setRGB(x, j, colorActual);
                x += width;
                diff.setRGB(x, j, colorDiff);
            }
        }

        ImageIO.write(diff, "png", out);
    }

}
