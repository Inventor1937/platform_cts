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

public class TestPow extends RSBaseCompute {

    private ScriptC_TestPow script;
    private ScriptC_TestPowRelaxed scriptRelaxed;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        script = new ScriptC_TestPow(mRS);
        scriptRelaxed = new ScriptC_TestPowRelaxed(mRS);
    }

    public class ArgumentsFloatFloatFloat {
        public float inBase;
        public float inExponent;
        public Target.Floaty out;
    }

    private void checkPowFloatFloatFloat() {
        Allocation inBase = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0x622b91eel, false);
        Allocation inExponent = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0x49a5f734l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.set_gAllocInExponent(inExponent);
            script.forEach_testPowFloatFloatFloat(inBase, out);
            verifyResultsPowFloatFloatFloat(inBase, inExponent, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testPowFloatFloatFloat: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.set_gAllocInExponent(inExponent);
            scriptRelaxed.forEach_testPowFloatFloatFloat(inBase, out);
            verifyResultsPowFloatFloatFloat(inBase, inExponent, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testPowFloatFloatFloat: " + e.toString());
        }
    }

    private void verifyResultsPowFloatFloatFloat(Allocation inBase, Allocation inExponent, Allocation out, boolean relaxed) {
        float[] arrayInBase = new float[INPUTSIZE * 1];
        Arrays.fill(arrayInBase, (float) 42);
        inBase.copyTo(arrayInBase);
        float[] arrayInExponent = new float[INPUTSIZE * 1];
        Arrays.fill(arrayInExponent, (float) 42);
        inExponent.copyTo(arrayInExponent);
        float[] arrayOut = new float[INPUTSIZE * 1];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 1 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloatFloat args = new ArgumentsFloatFloatFloat();
                args.inBase = arrayInBase[i];
                args.inExponent = arrayInExponent[i];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computePow(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 1 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inBase: ");
                        appendVariableToMessage(message, args.inBase);
                        message.append("\n");
                        message.append("Input inExponent: ");
                        appendVariableToMessage(message, args.inExponent);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 1 + j]);
                        if (!args.out.couldBe(arrayOut[i * 1 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkPowFloatFloatFloat" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkPowFloat2Float2Float2() {
        Allocation inBase = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0x895c2294l, false);
        Allocation inExponent = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0xbbad35fal, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 2), INPUTSIZE);
            script.set_gAllocInExponent(inExponent);
            script.forEach_testPowFloat2Float2Float2(inBase, out);
            verifyResultsPowFloat2Float2Float2(inBase, inExponent, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testPowFloat2Float2Float2: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 2), INPUTSIZE);
            scriptRelaxed.set_gAllocInExponent(inExponent);
            scriptRelaxed.forEach_testPowFloat2Float2Float2(inBase, out);
            verifyResultsPowFloat2Float2Float2(inBase, inExponent, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testPowFloat2Float2Float2: " + e.toString());
        }
    }

    private void verifyResultsPowFloat2Float2Float2(Allocation inBase, Allocation inExponent, Allocation out, boolean relaxed) {
        float[] arrayInBase = new float[INPUTSIZE * 2];
        Arrays.fill(arrayInBase, (float) 42);
        inBase.copyTo(arrayInBase);
        float[] arrayInExponent = new float[INPUTSIZE * 2];
        Arrays.fill(arrayInExponent, (float) 42);
        inExponent.copyTo(arrayInExponent);
        float[] arrayOut = new float[INPUTSIZE * 2];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 2 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloatFloat args = new ArgumentsFloatFloatFloat();
                args.inBase = arrayInBase[i * 2 + j];
                args.inExponent = arrayInExponent[i * 2 + j];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computePow(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 2 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inBase: ");
                        appendVariableToMessage(message, args.inBase);
                        message.append("\n");
                        message.append("Input inExponent: ");
                        appendVariableToMessage(message, args.inExponent);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 2 + j]);
                        if (!args.out.couldBe(arrayOut[i * 2 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkPowFloat2Float2Float2" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkPowFloat3Float3Float3() {
        Allocation inBase = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0x71d00807l, false);
        Allocation inExponent = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0x12cfb87dl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 3), INPUTSIZE);
            script.set_gAllocInExponent(inExponent);
            script.forEach_testPowFloat3Float3Float3(inBase, out);
            verifyResultsPowFloat3Float3Float3(inBase, inExponent, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testPowFloat3Float3Float3: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 3), INPUTSIZE);
            scriptRelaxed.set_gAllocInExponent(inExponent);
            scriptRelaxed.forEach_testPowFloat3Float3Float3(inBase, out);
            verifyResultsPowFloat3Float3Float3(inBase, inExponent, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testPowFloat3Float3Float3: " + e.toString());
        }
    }

    private void verifyResultsPowFloat3Float3Float3(Allocation inBase, Allocation inExponent, Allocation out, boolean relaxed) {
        float[] arrayInBase = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInBase, (float) 42);
        inBase.copyTo(arrayInBase);
        float[] arrayInExponent = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInExponent, (float) 42);
        inExponent.copyTo(arrayInExponent);
        float[] arrayOut = new float[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 3 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloatFloat args = new ArgumentsFloatFloatFloat();
                args.inBase = arrayInBase[i * 4 + j];
                args.inExponent = arrayInExponent[i * 4 + j];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computePow(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inBase: ");
                        appendVariableToMessage(message, args.inBase);
                        message.append("\n");
                        message.append("Input inExponent: ");
                        appendVariableToMessage(message, args.inExponent);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkPowFloat3Float3Float3" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkPowFloat4Float4Float4() {
        Allocation inBase = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0x5a43ed7al, false);
        Allocation inExponent = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0x69f23b00l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 4), INPUTSIZE);
            script.set_gAllocInExponent(inExponent);
            script.forEach_testPowFloat4Float4Float4(inBase, out);
            verifyResultsPowFloat4Float4Float4(inBase, inExponent, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testPowFloat4Float4Float4: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 4), INPUTSIZE);
            scriptRelaxed.set_gAllocInExponent(inExponent);
            scriptRelaxed.forEach_testPowFloat4Float4Float4(inBase, out);
            verifyResultsPowFloat4Float4Float4(inBase, inExponent, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testPowFloat4Float4Float4: " + e.toString());
        }
    }

    private void verifyResultsPowFloat4Float4Float4(Allocation inBase, Allocation inExponent, Allocation out, boolean relaxed) {
        float[] arrayInBase = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInBase, (float) 42);
        inBase.copyTo(arrayInBase);
        float[] arrayInExponent = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInExponent, (float) 42);
        inExponent.copyTo(arrayInExponent);
        float[] arrayOut = new float[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            for (int j = 0; j < 4 ; j++) {
                // Extract the inputs.
                ArgumentsFloatFloatFloat args = new ArgumentsFloatFloatFloat();
                args.inBase = arrayInBase[i * 4 + j];
                args.inExponent = arrayInExponent[i * 4 + j];
                // Figure out what the outputs should have been.
                Target target = new Target(Target.FunctionType.NORMAL, Target.ReturnType.FLOAT, relaxed);
                CoreMathVerifier.computePow(args, target);
                // Validate the outputs.
                boolean valid = true;
                if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                    valid = false;
                }
                if (!valid) {
                    if (!errorFound) {
                        errorFound = true;
                        message.append("Input inBase: ");
                        appendVariableToMessage(message, args.inBase);
                        message.append("\n");
                        message.append("Input inExponent: ");
                        appendVariableToMessage(message, args.inExponent);
                        message.append("\n");
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        if (!args.out.couldBe(arrayOut[i * 4 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                        message.append("Errors at");
                    }
                    message.append(" [");
                    message.append(Integer.toString(i));
                    message.append(", ");
                    message.append(Integer.toString(j));
                    message.append("]");
                }
            }
        }
        assertFalse("Incorrect output for checkPowFloat4Float4Float4" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    public void testPow() {
        checkPowFloatFloatFloat();
        checkPowFloat2Float2Float2();
        checkPowFloat3Float3Float3();
        checkPowFloat4Float4Float4();
    }
}
