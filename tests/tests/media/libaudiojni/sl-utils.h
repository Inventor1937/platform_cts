/*
 * Copyright (C) 2015 The Android Open Source Project
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

#ifndef ANDROID_SL_UTILS_H
#define ANDROID_SL_UTILS_H

#include <SLES/OpenSLES.h>
#include <SLES/OpenSLES_Android.h>
#include <jni.h>
#include <utils/Log.h>

#define CheckErr(res) LOG_ALWAYS_FATAL_IF( \
        (res) != SL_RESULT_SUCCESS, "result error %s", android::getSLErrStr(res));

namespace android {

/* Returns the error string for the OpenSL ES error code
 */
const char *getSLErrStr(int code);

/* Returns the OpenSL ES equivalent standard channel mask
 * for a given channel count, 0 if no such mask is available.
 */
SLuint32 channelCountToMask(unsigned channelCount);

/* Returns an OpenSL ES Engine object interface.
 * The engine created will be thread safe [3.2]
 * The underlying implementation may not support more than one engine. [4.1.1]
 *
 * @param global if true, return and open the global engine instance or make
 *   a local engine instance if false.
 * @return NULL if unsuccessful or the Engine SLObjectItf.
 */
SLObjectItf OpenSLEngine(bool global = true);

/* Closes an OpenSL ES Engine object returned by OpenSLEngine().
 */
void CloseSLEngine(SLObjectItf engine);

} // namespace android

#endif // ANDROID_SL_UTILS_H
