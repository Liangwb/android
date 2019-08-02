// IStudentService.aidl
package com.ok.myproject;

// Declare any non-default types here with import statements
import com.ok.myproject.Student;
import com.ok.myproject.ITaskCallback;
interface IStudentService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    /*void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);*/
    //保存用户自己的信息;
    void save(in Student student);
    String fileInfo();
    void mySava(in Student student);
    void registerCallback(ITaskCallback cb);
    void unregisterCallback(ITaskCallback cb);
}
