package com.smartlocation.multidexdrive;

public class Person {

    public static int num = -1;
    private String mName;
//    private String mAddr;
    private int mAge;

    public Person(String name, int age) {
        mName = name;
        mAge = age;
    }

    static {
        System.out.println("Base " + num);
    }

//    public String getName() {
//        return mName;
//    }
//
//    public void setName(String name) {
//        mName = name;
//    }
//
//    public String getAddr() {
//        return mAddr;
//    }
//
//    public void setAddr(String addr) {
//        mAddr = addr;
//    }
//
//    public int getAge() {
//        return mAge;
//    }
//
//    public void setAge(int age) {
//        mAge = age;
//    }

}
