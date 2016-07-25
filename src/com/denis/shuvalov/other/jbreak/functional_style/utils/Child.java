package com.denis.shuvalov.other.jbreak.functional_style.utils;

public class Child {
    int age;
    String namel;

    public int getAge() {
        return age;
    }

    public Child setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return namel;
    }

    public Child setNamel(String namel) {
        this.namel = namel;
        return this;
    }
}
