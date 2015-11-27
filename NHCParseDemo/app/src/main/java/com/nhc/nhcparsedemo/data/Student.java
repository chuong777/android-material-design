package com.nhc.nhcparsedemo.data;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.List;

/**
 * Created by NHC on 18/11/15.
 */
@ParseClassName("Student")
public class Student extends ParseObject {
    private String name;
    private int age;
    private List<String> email;

    public Student(){}

    public Student(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        if (name == null) name = getString("name");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        put("name", name);
    }

    public int getAge() {
        if (age == 0) age = getInt("age");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        put("age", age);
    }

    public List<String> getEmail() {
        if (email == null) email = getList("email");
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
        put("email", email);
    }
}
