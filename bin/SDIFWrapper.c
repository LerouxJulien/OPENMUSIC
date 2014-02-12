//
//  SDIFWrapper.c
//
//
//  Created by Steven on 11/02/2014.
//
//

#include <stdio.h>
#include <SDIFWrapper.h>
#include "sdif.h"

JNIEXPORT jobject JNICALL Java_SDIFWrapper_sdifOpenFile
(JNIEnv * env, jobject, jstring filename, jobject mode){
    const char *name = env->GetStringUTFChars(filename, JNI_FALSE);
    return SdifFOpen (name, mode);
    
}

JNIEXPORT void JNICALL Java_SDIFWrapper_sdifCloseFile
(JNIEnv *env, jobject obj, jobject param){
    SdifCloseFile(param);
}

JNIEXPORT jboolean JNICALL Java_SDIFWrapper_sdifCheckFile
(JNIEnv *, jobject obj, jstring filename){
    const char *name = env->GetStringUTFChars(filename, JNI_FALSE);
    return (SdifCheckFileFormat(name) != 0);
}

