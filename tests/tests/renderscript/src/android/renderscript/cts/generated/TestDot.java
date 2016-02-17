/*
 * Copyright (C) 2016 The Android Open Source Project
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

// Don't edit this file!  It is auto-generated by frameworks/rs/api/generate.sh.

package android.renderscript.cts;

import android.renderscript.Allocation;
import android.renderscript.RSRuntimeException;
import android.renderscript.Element;
import android.renderscript.cts.Target;

import java.util.Arrays;

public class TestDot extends RSBaseCompute {

    private ScriptC_TestDot script;
    private ScriptC_TestDotRelaxed scriptRelaxed;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        script = new ScriptC_TestDot(mRS);
        scriptRelaxed = new ScriptC_TestDotRelaxed(mRS);
    }

    public class ArgumentsFloatFloatFloat {
        public float inLeftVector;
        public float inRightVector;
        public Target.Floaty out;
    }

    private void checkDotFloatFloatFloat() {
        Allocation inLeftVector = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0xf7ff2d3el, false);
        Allocation inRightVector = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0x15f562efl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocInRightVector(inRightVector);
            script.forEach_testDotFloatFloatFloat(inLeftVector, out);
            verifyResultsDotFloatFloatFloat(inLeftVector, inRightVector, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testDotFloatFloatFloat: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInRightVector(inRightVector);
            scriptRelaxed.forEach_testDotFloatFloatFloat(inLeftVector, out);
            verifyResultsDotFloatFloatFloat(inLeftVector, inRightVector, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testDotFloatFloatFloat: " + e.toString());
        }
    }

    private void verifyResultsDotFloatFloatFloat(Allocation inLeftVector, Allocation inRightVector, Allocation out, boolean relaxed) {
        float[] arrayInLeftVector = new float[INPUTSIZE * 1];
        Arrays.fill(arrayInLeftVector, (float) 42);
        inLeftVector.copyTo(arrayInLeftVector);
        float[] arrayInRightVector = new float[INPUTSIZE * 1];
        Arrays.fill(arrayInRightVector, (float) 42);
        inRightVector.copyTo(arrayInRightVector);
        float[] arrayOut = new float[INPUTSIZE * 1];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatFloatFloat args = new ArgumentsFloatFloatFloat();
            // Create the appropriate sized arrays in args
            // Fill args with the input values
            args.inLeftVector = arrayInLeftVector[i];
            args.inRightVector = arrayInRightVector[i];
            Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
            CoreMathVerifier.computeDot(args, target);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            if (!args.out.couldBe(arrayOut[i])) {
                valid = false;
            }
            if (!valid) {
                if (!errorFound) {
                    errorFound = true;
                    message.append("Input inLeftVector: ");
                    appendVariableToMessage(message, arrayInLeftVector[i]);
                    message.append("\n");
                    message.append("Input inRightVector: ");
                    appendVariableToMessage(message, arrayInRightVector[i]);
                    message.append("\n");
                    message.append("Expected output out: ");
                    appendVariableToMessage(message, args.out);
                    message.append("\n");
                    message.append("Actual   output out: ");
                    appendVariableToMessage(message, arrayOut[i]);
                    if (!args.out.couldBe(arrayOut[i])) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    message.append("Errors at");
                }
                message.append(" [");
                message.append(Integer.toString(i));
                message.append("]");
            }
        }
        assertFalse("Incorrect output for checkDotFloatFloatFloat" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    public class ArgumentsFloatNFloatNFloat {
        public float[] inLeftVector;
        public float[] inRightVector;
        public Target.Floaty out;
    }

    private void checkDotFloat2Float2Float() {
        Allocation inLeftVector = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0xbf79d3a2l, false);
        Allocation inRightVector = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0x978f55bbl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocInRightVector(inRightVector);
            script.forEach_testDotFloat2Float2Float(inLeftVector, out);
            verifyResultsDotFloat2Float2Float(inLeftVector, inRightVector, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testDotFloat2Float2Float: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInRightVector(inRightVector);
            scriptRelaxed.forEach_testDotFloat2Float2Float(inLeftVector, out);
            verifyResultsDotFloat2Float2Float(inLeftVector, inRightVector, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testDotFloat2Float2Float: " + e.toString());
        }
    }

    private void verifyResultsDotFloat2Float2Float(Allocation inLeftVector, Allocation inRightVector, Allocation out, boolean relaxed) {
        float[] arrayInLeftVector = new float[INPUTSIZE * 2];
        Arrays.fill(arrayInLeftVector, (float) 42);
        inLeftVector.copyTo(arrayInLeftVector);
        float[] arrayInRightVector = new float[INPUTSIZE * 2];
        Arrays.fill(arrayInRightVector, (float) 42);
        inRightVector.copyTo(arrayInRightVector);
        float[] arrayOut = new float[INPUTSIZE * 1];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatNFloatNFloat args = new ArgumentsFloatNFloatNFloat();
            // Create the appropriate sized arrays in args
            args.inLeftVector = new float[2];
            args.inRightVector = new float[2];
            // Fill args with the input values
            for (int j = 0; j < 2 ; j++) {
                args.inLeftVector[j] = arrayInLeftVector[i * 2 + j];
            }
            for (int j = 0; j < 2 ; j++) {
                args.inRightVector[j] = arrayInRightVector[i * 2 + j];
            }
            Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
            CoreMathVerifier.computeDot(args, target);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            if (!args.out.couldBe(arrayOut[i])) {
                valid = false;
            }
            if (!valid) {
                if (!errorFound) {
                    errorFound = true;
                    for (int j = 0; j < 2 ; j++) {
                        message.append("Input inLeftVector: ");
                        appendVariableToMessage(message, arrayInLeftVector[i * 2 + j]);
                        message.append("\n");
                    }
                    for (int j = 0; j < 2 ; j++) {
                        message.append("Input inRightVector: ");
                        appendVariableToMessage(message, arrayInRightVector[i * 2 + j]);
                        message.append("\n");
                    }
                    message.append("Expected output out: ");
                    appendVariableToMessage(message, args.out);
                    message.append("\n");
                    message.append("Actual   output out: ");
                    appendVariableToMessage(message, arrayOut[i]);
                    if (!args.out.couldBe(arrayOut[i])) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    message.append("Errors at");
                }
                message.append(" [");
                message.append(Integer.toString(i));
                message.append("]");
            }
        }
        assertFalse("Incorrect output for checkDotFloat2Float2Float" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkDotFloat3Float3Float() {
        Allocation inLeftVector = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0xe11887f0l, false);
        Allocation inRightVector = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0x3d379ed5l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocInRightVector(inRightVector);
            script.forEach_testDotFloat3Float3Float(inLeftVector, out);
            verifyResultsDotFloat3Float3Float(inLeftVector, inRightVector, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testDotFloat3Float3Float: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInRightVector(inRightVector);
            scriptRelaxed.forEach_testDotFloat3Float3Float(inLeftVector, out);
            verifyResultsDotFloat3Float3Float(inLeftVector, inRightVector, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testDotFloat3Float3Float: " + e.toString());
        }
    }

    private void verifyResultsDotFloat3Float3Float(Allocation inLeftVector, Allocation inRightVector, Allocation out, boolean relaxed) {
        float[] arrayInLeftVector = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInLeftVector, (float) 42);
        inLeftVector.copyTo(arrayInLeftVector);
        float[] arrayInRightVector = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInRightVector, (float) 42);
        inRightVector.copyTo(arrayInRightVector);
        float[] arrayOut = new float[INPUTSIZE * 1];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatNFloatNFloat args = new ArgumentsFloatNFloatNFloat();
            // Create the appropriate sized arrays in args
            args.inLeftVector = new float[3];
            args.inRightVector = new float[3];
            // Fill args with the input values
            for (int j = 0; j < 3 ; j++) {
                args.inLeftVector[j] = arrayInLeftVector[i * 4 + j];
            }
            for (int j = 0; j < 3 ; j++) {
                args.inRightVector[j] = arrayInRightVector[i * 4 + j];
            }
            Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
            CoreMathVerifier.computeDot(args, target);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            if (!args.out.couldBe(arrayOut[i])) {
                valid = false;
            }
            if (!valid) {
                if (!errorFound) {
                    errorFound = true;
                    for (int j = 0; j < 3 ; j++) {
                        message.append("Input inLeftVector: ");
                        appendVariableToMessage(message, arrayInLeftVector[i * 4 + j]);
                        message.append("\n");
                    }
                    for (int j = 0; j < 3 ; j++) {
                        message.append("Input inRightVector: ");
                        appendVariableToMessage(message, arrayInRightVector[i * 4 + j]);
                        message.append("\n");
                    }
                    message.append("Expected output out: ");
                    appendVariableToMessage(message, args.out);
                    message.append("\n");
                    message.append("Actual   output out: ");
                    appendVariableToMessage(message, arrayOut[i]);
                    if (!args.out.couldBe(arrayOut[i])) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    message.append("Errors at");
                }
                message.append(" [");
                message.append(Integer.toString(i));
                message.append("]");
            }
        }
        assertFalse("Incorrect output for checkDotFloat3Float3Float" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkDotFloat4Float4Float() {
        Allocation inLeftVector = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0x2b73c3el, false);
        Allocation inRightVector = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0xe2dfe7efl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocInRightVector(inRightVector);
            script.forEach_testDotFloat4Float4Float(inLeftVector, out);
            verifyResultsDotFloat4Float4Float(inLeftVector, inRightVector, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testDotFloat4Float4Float: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInRightVector(inRightVector);
            scriptRelaxed.forEach_testDotFloat4Float4Float(inLeftVector, out);
            verifyResultsDotFloat4Float4Float(inLeftVector, inRightVector, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testDotFloat4Float4Float: " + e.toString());
        }
    }

    private void verifyResultsDotFloat4Float4Float(Allocation inLeftVector, Allocation inRightVector, Allocation out, boolean relaxed) {
        float[] arrayInLeftVector = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInLeftVector, (float) 42);
        inLeftVector.copyTo(arrayInLeftVector);
        float[] arrayInRightVector = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInRightVector, (float) 42);
        inRightVector.copyTo(arrayInRightVector);
        float[] arrayOut = new float[INPUTSIZE * 1];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatNFloatNFloat args = new ArgumentsFloatNFloatNFloat();
            // Create the appropriate sized arrays in args
            args.inLeftVector = new float[4];
            args.inRightVector = new float[4];
            // Fill args with the input values
            for (int j = 0; j < 4 ; j++) {
                args.inLeftVector[j] = arrayInLeftVector[i * 4 + j];
            }
            for (int j = 0; j < 4 ; j++) {
                args.inRightVector[j] = arrayInRightVector[i * 4 + j];
            }
            Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
            CoreMathVerifier.computeDot(args, target);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            if (!args.out.couldBe(arrayOut[i])) {
                valid = false;
            }
            if (!valid) {
                if (!errorFound) {
                    errorFound = true;
                    for (int j = 0; j < 4 ; j++) {
                        message.append("Input inLeftVector: ");
                        appendVariableToMessage(message, arrayInLeftVector[i * 4 + j]);
                        message.append("\n");
                    }
                    for (int j = 0; j < 4 ; j++) {
                        message.append("Input inRightVector: ");
                        appendVariableToMessage(message, arrayInRightVector[i * 4 + j]);
                        message.append("\n");
                    }
                    message.append("Expected output out: ");
                    appendVariableToMessage(message, args.out);
                    message.append("\n");
                    message.append("Actual   output out: ");
                    appendVariableToMessage(message, arrayOut[i]);
                    if (!args.out.couldBe(arrayOut[i])) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    message.append("Errors at");
                }
                message.append(" [");
                message.append(Integer.toString(i));
                message.append("]");
            }
        }
        assertFalse("Incorrect output for checkDotFloat4Float4Float" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    public void testDot() {
        checkDotFloatFloatFloat();
        checkDotFloat2Float2Float();
        checkDotFloat3Float3Float();
        checkDotFloat4Float4Float();
    }
}
