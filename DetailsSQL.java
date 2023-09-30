package com.example.usamasqlite;

public class Details {

    String rollno,name,age;

    public Details() {
    }

    public Details(String rollno, String name, String age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
