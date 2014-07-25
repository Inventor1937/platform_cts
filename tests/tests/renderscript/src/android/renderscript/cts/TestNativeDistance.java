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

// Don't edit this file!  It is auto-generated by frameworks/rs/api/gen_runtime.

package android.renderscript.cts;

import android.renderscript.Allocation;
import android.renderscript.RSRuntimeException;
import android.renderscript.Element;

public class TestNativeDistance extends RSBaseCompute {

    private ScriptC_TestNativeDistance script;
    private ScriptC_TestNativeDistanceRelaxed scriptRelaxed;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        script = new ScriptC_TestNativeDistance(mRS);
        scriptRelaxed = new ScriptC_TestNativeDistanceRelaxed(mRS);
    }

    public class ArgumentsFloatFloatFloat {
        public float inLhs;
        public float inRhs;
        public Floaty out;
    }

    private void checkNativeDistanceFloatFloatFloat() {
        Allocation inLhs = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0xe0fd4252f8556ff6l, false);
        Allocation inRhs = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0xe0fd4252f8559b4cl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocInRhs(inRhs);
            script.forEach_testNativeDistanceFloatFloatFloat(inLhs, out);
            verifyResultsNativeDistanceFloatFloatFloat(inLhs, inRhs, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testNativeDistanceFloatFloatFloat: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInRhs(inRhs);
            scriptRelaxed.forEach_testNativeDistanceFloatFloatFloat(inLhs, out);
            verifyResultsNativeDistanceFloatFloatFloat(inLhs, inRhs, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testNativeDistanceFloatFloatFloat: " + e.toString());
        }
    }

    private void verifyResultsNativeDistanceFloatFloatFloat(Allocation inLhs, Allocation inRhs, Allocation out, boolean relaxed) {
        float[] arrayInLhs = new float[INPUTSIZE * 1];
        inLhs.copyTo(arrayInLhs);
        float[] arrayInRhs = new float[INPUTSIZE * 1];
        inRhs.copyTo(arrayInRhs);
        float[] arrayOut = new float[INPUTSIZE * 1];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatFloatFloat args = new ArgumentsFloatFloatFloat();
            // Create the appropriate sized arrays in args
            // Fill args with the input values
            args.inLhs = arrayInLhs[i];
            args.inRhs = arrayInRhs[i];
            Floaty.setRelaxed(relaxed);
            CoreMathVerifier.computeNativeDistance(args);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            if (!args.out.couldBe(arrayOut[i])) {
                valid = false;
            }
            if (!valid) {
                StringBuilder message = new StringBuilder();
                message.append("Input inLhs: ");
                message.append(String.format("%14.8g %8x %15a",
                        arrayInLhs[i], Float.floatToRawIntBits(arrayInLhs[i]), arrayInLhs[i]));
                message.append("\n");
                message.append("Input inRhs: ");
                message.append(String.format("%14.8g %8x %15a",
                        arrayInRhs[i], Float.floatToRawIntBits(arrayInRhs[i]), arrayInRhs[i]));
                message.append("\n");
                message.append("Expected output out: ");
                message.append(args.out.toString());
                message.append("\n");
                message.append("Actual   output out: ");
                message.append(String.format("%14.8g %8x %15a",
                        arrayOut[i], Float.floatToRawIntBits(arrayOut[i]), arrayOut[i]));
                if (!args.out.couldBe(arrayOut[i])) {
                    message.append(" FAIL");
                }
                message.append("\n");
                assertTrue("Incorrect output for checkNativeDistanceFloatFloatFloat" +
                        (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
            }
        }
    }

    public class ArgumentsFloatNFloatNFloat {
        public float[] inLhs;
        public float[] inRhs;
        public Floaty out;
    }

    private void checkNativeDistanceFloat2Float2Float() {
        Allocation inLhs = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0x28a9ea2ea1fd926al, false);
        Allocation inRhs = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0x28a9ea2ea1fdbdc0l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocInRhs(inRhs);
            script.forEach_testNativeDistanceFloat2Float2Float(inLhs, out);
            verifyResultsNativeDistanceFloat2Float2Float(inLhs, inRhs, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testNativeDistanceFloat2Float2Float: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInRhs(inRhs);
            scriptRelaxed.forEach_testNativeDistanceFloat2Float2Float(inLhs, out);
            verifyResultsNativeDistanceFloat2Float2Float(inLhs, inRhs, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testNativeDistanceFloat2Float2Float: " + e.toString());
        }
    }

    private void verifyResultsNativeDistanceFloat2Float2Float(Allocation inLhs, Allocation inRhs, Allocation out, boolean relaxed) {
        float[] arrayInLhs = new float[INPUTSIZE * 2];
        inLhs.copyTo(arrayInLhs);
        float[] arrayInRhs = new float[INPUTSIZE * 2];
        inRhs.copyTo(arrayInRhs);
        float[] arrayOut = new float[INPUTSIZE * 1];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatNFloatNFloat args = new ArgumentsFloatNFloatNFloat();
            // Create the appropriate sized arrays in args
            args.inLhs = new float[2];
            args.inRhs = new float[2];
            // Fill args with the input values
            for (int j = 0; j < 2 ; j++) {
                args.inLhs[j] = arrayInLhs[i * 2 + j];
            }
            for (int j = 0; j < 2 ; j++) {
                args.inRhs[j] = arrayInRhs[i * 2 + j];
            }
            Floaty.setRelaxed(relaxed);
            CoreMathVerifier.computeNativeDistance(args);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            if (!args.out.couldBe(arrayOut[i])) {
                valid = false;
            }
            if (!valid) {
                StringBuilder message = new StringBuilder();
                for (int j = 0; j < 2 ; j++) {
                    message.append("Input inLhs: ");
                    message.append(String.format("%14.8g %8x %15a",
                            arrayInLhs[i * 2 + j], Float.floatToRawIntBits(arrayInLhs[i * 2 + j]), arrayInLhs[i * 2 + j]));
                    message.append("\n");
                }
                for (int j = 0; j < 2 ; j++) {
                    message.append("Input inRhs: ");
                    message.append(String.format("%14.8g %8x %15a",
                            arrayInRhs[i * 2 + j], Float.floatToRawIntBits(arrayInRhs[i * 2 + j]), arrayInRhs[i * 2 + j]));
                    message.append("\n");
                }
                message.append("Expected output out: ");
                message.append(args.out.toString());
                message.append("\n");
                message.append("Actual   output out: ");
                message.append(String.format("%14.8g %8x %15a",
                        arrayOut[i], Float.floatToRawIntBits(arrayOut[i]), arrayOut[i]));
                if (!args.out.couldBe(arrayOut[i])) {
                    message.append(" FAIL");
                }
                message.append("\n");
                assertTrue("Incorrect output for checkNativeDistanceFloat2Float2Float" +
                        (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
            }
        }
    }

    private void checkNativeDistanceFloat3Float3Float() {
        Allocation inLhs = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0x559b398ef213adc4l, false);
        Allocation inRhs = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0x559b398ef213d91al, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocInRhs(inRhs);
            script.forEach_testNativeDistanceFloat3Float3Float(inLhs, out);
            verifyResultsNativeDistanceFloat3Float3Float(inLhs, inRhs, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testNativeDistanceFloat3Float3Float: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInRhs(inRhs);
            scriptRelaxed.forEach_testNativeDistanceFloat3Float3Float(inLhs, out);
            verifyResultsNativeDistanceFloat3Float3Float(inLhs, inRhs, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testNativeDistanceFloat3Float3Float: " + e.toString());
        }
    }

    private void verifyResultsNativeDistanceFloat3Float3Float(Allocation inLhs, Allocation inRhs, Allocation out, boolean relaxed) {
        float[] arrayInLhs = new float[INPUTSIZE * 4];
        inLhs.copyTo(arrayInLhs);
        float[] arrayInRhs = new float[INPUTSIZE * 4];
        inRhs.copyTo(arrayInRhs);
        float[] arrayOut = new float[INPUTSIZE * 1];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatNFloatNFloat args = new ArgumentsFloatNFloatNFloat();
            // Create the appropriate sized arrays in args
            args.inLhs = new float[3];
            args.inRhs = new float[3];
            // Fill args with the input values
            for (int j = 0; j < 3 ; j++) {
                args.inLhs[j] = arrayInLhs[i * 4 + j];
            }
            for (int j = 0; j < 3 ; j++) {
                args.inRhs[j] = arrayInRhs[i * 4 + j];
            }
            Floaty.setRelaxed(relaxed);
            CoreMathVerifier.computeNativeDistance(args);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            if (!args.out.couldBe(arrayOut[i])) {
                valid = false;
            }
            if (!valid) {
                StringBuilder message = new StringBuilder();
                for (int j = 0; j < 3 ; j++) {
                    message.append("Input inLhs: ");
                    message.append(String.format("%14.8g %8x %15a",
                            arrayInLhs[i * 4 + j], Float.floatToRawIntBits(arrayInLhs[i * 4 + j]), arrayInLhs[i * 4 + j]));
                    message.append("\n");
                }
                for (int j = 0; j < 3 ; j++) {
                    message.append("Input inRhs: ");
                    message.append(String.format("%14.8g %8x %15a",
                            arrayInRhs[i * 4 + j], Float.floatToRawIntBits(arrayInRhs[i * 4 + j]), arrayInRhs[i * 4 + j]));
                    message.append("\n");
                }
                message.append("Expected output out: ");
                message.append(args.out.toString());
                message.append("\n");
                message.append("Actual   output out: ");
                message.append(String.format("%14.8g %8x %15a",
                        arrayOut[i], Float.floatToRawIntBits(arrayOut[i]), arrayOut[i]));
                if (!args.out.couldBe(arrayOut[i])) {
                    message.append(" FAIL");
                }
                message.append("\n");
                assertTrue("Incorrect output for checkNativeDistanceFloat3Float3Float" +
                        (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
            }
        }
    }

    private void checkNativeDistanceFloat4Float4Float() {
        Allocation inLhs = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0x828c88ef4229c91el, false);
        Allocation inRhs = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0x828c88ef4229f474l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocInRhs(inRhs);
            script.forEach_testNativeDistanceFloat4Float4Float(inLhs, out);
            verifyResultsNativeDistanceFloat4Float4Float(inLhs, inRhs, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testNativeDistanceFloat4Float4Float: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInRhs(inRhs);
            scriptRelaxed.forEach_testNativeDistanceFloat4Float4Float(inLhs, out);
            verifyResultsNativeDistanceFloat4Float4Float(inLhs, inRhs, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testNativeDistanceFloat4Float4Float: " + e.toString());
        }
    }

    private void verifyResultsNativeDistanceFloat4Float4Float(Allocation inLhs, Allocation inRhs, Allocation out, boolean relaxed) {
        float[] arrayInLhs = new float[INPUTSIZE * 4];
        inLhs.copyTo(arrayInLhs);
        float[] arrayInRhs = new float[INPUTSIZE * 4];
        inRhs.copyTo(arrayInRhs);
        float[] arrayOut = new float[INPUTSIZE * 1];
        out.copyTo(arrayOut);
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatNFloatNFloat args = new ArgumentsFloatNFloatNFloat();
            // Create the appropriate sized arrays in args
            args.inLhs = new float[4];
            args.inRhs = new float[4];
            // Fill args with the input values
            for (int j = 0; j < 4 ; j++) {
                args.inLhs[j] = arrayInLhs[i * 4 + j];
            }
            for (int j = 0; j < 4 ; j++) {
                args.inRhs[j] = arrayInRhs[i * 4 + j];
            }
            Floaty.setRelaxed(relaxed);
            CoreMathVerifier.computeNativeDistance(args);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            if (!args.out.couldBe(arrayOut[i])) {
                valid = false;
            }
            if (!valid) {
                StringBuilder message = new StringBuilder();
                for (int j = 0; j < 4 ; j++) {
                    message.append("Input inLhs: ");
                    message.append(String.format("%14.8g %8x %15a",
                            arrayInLhs[i * 4 + j], Float.floatToRawIntBits(arrayInLhs[i * 4 + j]), arrayInLhs[i * 4 + j]));
                    message.append("\n");
                }
                for (int j = 0; j < 4 ; j++) {
                    message.append("Input inRhs: ");
                    message.append(String.format("%14.8g %8x %15a",
                            arrayInRhs[i * 4 + j], Float.floatToRawIntBits(arrayInRhs[i * 4 + j]), arrayInRhs[i * 4 + j]));
                    message.append("\n");
                }
                message.append("Expected output out: ");
                message.append(args.out.toString());
                message.append("\n");
                message.append("Actual   output out: ");
                message.append(String.format("%14.8g %8x %15a",
                        arrayOut[i], Float.floatToRawIntBits(arrayOut[i]), arrayOut[i]));
                if (!args.out.couldBe(arrayOut[i])) {
                    message.append(" FAIL");
                }
                message.append("\n");
                assertTrue("Incorrect output for checkNativeDistanceFloat4Float4Float" +
                        (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), valid);
            }
        }
    }

    public void testNativeDistance() {
        checkNativeDistanceFloatFloatFloat();
        checkNativeDistanceFloat2Float2Float();
        checkNativeDistanceFloat3Float3Float();
        checkNativeDistanceFloat4Float4Float();
    }
}
