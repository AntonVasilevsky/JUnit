package org.example.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private int age;
    private String sex;
    public static int counter = 0;
    public static Map<Integer, Human> humans = new HashMap<>();

    public Human(String name, int age, String sex) {

        this.name = name;
        this.age = age;
        this.sex = sex;
        if(!isPresent()){
            counter++;
            humans.put(counter, this);
        }
    }
    public boolean isPresent(){
        for (Human human : humans.values()){
            if(human.equals(this) && human.hashCode() == this.hashCode())
                return true;
        }
        return false;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(name, human.name) && Objects.equals(sex, human.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
