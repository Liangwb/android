package com.ok.myproject;

import android.app.Service;
import android.os.Parcelable;
import android.os.Parcel;
public class Student implements Parcelable {

    private int id;
    private String name;
    private String sex;
    private double sorce;



    public Student(int id, String name, String sex, double sorce) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.sorce = sorce;
    }

    public Student(){
        this.id = 1;
        this.name = "java";
        this.sex="男";
        this.sorce = 90;

    }


    protected Student(Parcel in) {
        id = in.readInt();
        name = in.readString();
        sex = in.readString();
        sorce = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(sex);
        dest.writeDouble(sorce);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSorce(double sorce) {
        this.sorce = sorce;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public double getSorce() {
        return sorce;
    }


}
