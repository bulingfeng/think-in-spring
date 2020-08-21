package com.bulingfeng.ioc.container.overview.entity;

/**
 * @Author:bulingfeng
 * @Date: 2020-08-16
 */
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static Person createPerson(){
        Person  person=new Person();
        person.setAge(18);
        person.setName("bulingfeng");
        return person;
    }
}
