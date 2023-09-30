package com.example.firebasetutorial;

public class Details {
    private String name,age,rollno;
    public Details() {
    }
    public Details(String name, String age,String rollno){
        this.name=name;
        this.age=age;
        this.rollno=rollno;
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
