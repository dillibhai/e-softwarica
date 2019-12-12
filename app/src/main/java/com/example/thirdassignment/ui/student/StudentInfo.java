package com.example.thirdassignment.ui.student;

import java.io.Serializable;

public class StudentInfo implements Serializable {
    private String fullname;
    private String age;
    private String gender;
    private String address;
    public StudentInfo(String fullname, String age, String gender, String address) {
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }


    public String getName() {
        return fullname;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    public String getAddress() {
        return address;
    }
}
