// MyAIDLTest.aidl
package com.example.service;

// Declare any non-default types here with import statements
import com.example.service.Student;

interface MyAIDLTest {

    int add(int arg1, int arg2);

    String inStudentInfo(in Student student);//代表student值由客户端输入

    String outStudentInfo(out Student student);//代表student值由服务端设置

    String inOutStudentInfo(inout Student student);//代表客户端和服务端都可以设置
}
