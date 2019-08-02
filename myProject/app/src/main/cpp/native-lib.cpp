#include <iostream>
#include <jni.h>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

class Student{

public:
    int id;
    string name;
    string sex;
    double  socre;
};




vector<Student> students;
vector<Student>::iterator iter;

extern "C" JNIEXPORT jstring JNICALL
Java_com_ok_myproject_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}





extern "C"
JNIEXPORT jstring JNICALL
Java_com_ok_myproject_StudentService_getFileInfo(JNIEnv *env, jobject instance) {

    // TODO
    string myInfo;
    stringstream ss;
    for(iter = students.begin();iter!=students.end();iter++){
           ss<<"id:"<<iter->id<<endl
           <<"name:"<<iter->name<<endl
           <<"sex"<<iter->sex<<endl
           <<"score"<<iter->socre<<endl;

           myInfo =ss.str();
           /*string myid = *iter->id;
           myInfo = myInfo+"name:"+iter->id;*//*+iter->name+endl*//*
           myInfo = myInfo+"sex" *//*+ iter->sex+endl*//*;
           myInfo = myInfo+"score"*//*+ iter->score+endl*//*;*/

    }
    return env->NewStringUTF(myInfo.c_str());
}






extern "C"
JNIEXPORT void JNICALL
Java_com_ok_myproject_StudentService_filesave(JNIEnv *env, jobject instance, jobject student);

extern "C" void Java_com_ok_myproject_StudentService_filesave(JNIEnv *env, jobject instance, jobject student) {
    jclass objClass = env->GetObjectClass(student);
    if(objClass){
        //获取相关数据
        jfieldID  intID=env->GetFieldID(objClass,"id","I");
        jint intId =(int)env->GetIntField(student,intID);


        jfieldID  strName=env->GetFieldID(objClass,"name","Ljava/lang/String;");
        jstring jstrName = (jstring)env->GetObjectField(student,strName);
        string myName = env->GetStringUTFChars(jstrName,NULL);

        jfieldID  strSex=env->GetFieldID(objClass,"sex","Ljava/lang/String;");
        jstring jstrSex = (jstring)env->GetObjectField(student,strSex);
        string mySex = env->GetStringUTFChars(jstrSex ,NULL);


        jfieldID  doubleScore=env->GetFieldID(objClass,"sorce","D");
        jdouble myScore = (double)env->GetDoubleField(student,doubleScore);


        Student newStudent;
        newStudent.id = intId;
        newStudent.name =myName;
        newStudent.sex = mySex;
        newStudent.socre = myScore;

        students.push_back(newStudent);

    }

    // TODO

}
