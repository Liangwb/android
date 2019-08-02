#include <jni.h>
#include <iostream>
#include <string>
#include <cstdlib>
#include <android/log.h>
using namespace std;

#define TAG "###############lwb-jni" // 这个是自定义的LOG的标识
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG ,__VA_ARGS__) // 定义LOGD类型
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG ,__VA_ARGS__) // 定义LOGI类型
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,TAG ,__VA_ARGS__) // 定义LOGW类型
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG ,__VA_ARGS__) // 定义LOGE类型
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,TAG ,__VA_ARGS__) // 定义LOGF类型

char *numString(int n){

    int size = 0;
    int m = n;
    while(m >0){
        size++;
        m /=10;
    }

    char *p = new char[size+1];
    char *q = p;
    m=n;
    while(m>0){
        *p = '0'+m%10;
        m/=10;
        p++;

    }
    *p='\0';


    return p;
}



extern "C" JNIEXPORT jstring JNICALL
Java_com_ok_myc_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}



extern "C"
JNIEXPORT jstring JNICALL
Java_com_ok_myc_MainActivity_myString(JNIEnv *env, jobject instance, jint num) {



   LOGE("Welcome to use myString");


    return env->NewStringUTF("Yes");
}