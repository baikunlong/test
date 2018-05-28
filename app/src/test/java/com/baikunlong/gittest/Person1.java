package com.baikunlong.gittest;

public class Person1 {
    private String name;
    private int age;
    private String sex;

    // 空的构造函数
    public Person1() {
        System.out.println("不带参数的构造函数");
    }

    /**
     * 带参数的构造函数
     *
     * @param name 姓名
     * @param age  年龄
     * @param sex  性别
     */
    public Person1(String name, int age, String sex) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        System.out.println("带参数的构造函数");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void show() {
        System.out.println("无参数的show()方法");
    }

    public void show(String str) {
        System.out.println("带参数的show()方法" + str);
    }

    private String eat(String name) {
        return "我" + name + "很能吃！";
    }

    public void showInfo(String name, int age) {
        System.out.println("我的名字是：" + name + "\t\t年龄：" + age);
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("main方法中-------->");
        for (String string : args) {
            System.out.print(string + "\t\t");
        }
    }

}