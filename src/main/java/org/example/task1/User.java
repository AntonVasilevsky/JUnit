package org.example.task1;


import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private Sex sex;
    private static Map<Integer, User> allUsers = new HashMap<>();
    private static int countId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }



    public static void setAllUsers(Map<Integer, User> allUsers) {
        User.allUsers = allUsers;
    }

    public static int getCountId() {
        return countId;
    }

    public static void setCountId(int countId) {
        User.countId = countId;
    }

    public User(String name, int age, Sex sex) {
       if(!(name == null || name.isEmpty() || age == 0 || sex == null)) {

           this.name = name;
           this.age = age;
           this.sex = sex;
           if (!hasUser()) {
               countId++;
               this.id = countId;
               allUsers.put(id, this);
           }
       }

    }
    public boolean hasUser(){
        for(User user : allUsers.values()){
            if(user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.getAge() && Objects.equals(name, user.name) && sex.equals(user.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public static List<User> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getAllUsers(Sex sex){
        List<User> listAllUsers = new ArrayList<>();
        allUsers.values().forEach( user -> {
            if(user.sex == sex)
                listAllUsers.add(user);
        }       );
        return listAllUsers;
    }

    public static int getHowManyUsers(){
        return allUsers.size();
    }
    public static int getHowManyUsers(Sex sex){
        return getAllUsers(sex).size();
    }
    public static int getAllAgeUsers(){
        int ageSum = 0;
        for(User user : allUsers.values()){
            ageSum += user.getAge();
        }
        return ageSum;
    }
    public static int getAllAgeUsers(Sex sex){
        int ageSum = 0;
        for(User user : allUsers.values()){
            if(user.sex == sex){
                ageSum += user.getAge();
            }
        }
        return ageSum;
    }
    public static int getAverageAge(){
        return getAllAgeUsers() / getHowManyUsers();
    }
    public static int getAverageAge(Sex sex){
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }



}

