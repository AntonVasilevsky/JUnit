package org.example.task2;

import java.util.*;

public class Main {
    public static int a = 3;
    public static int b = 30;
    public static String string = "abc";
    public static int[] array = {1,2,3};



    public static int getBiggestOfTwo(int a, int b){
        return Math.max(a, b);
    }

    public static boolean isAlphabetical(String string){
       char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length-2; i++) {
            if(chars[i] > chars[i+1]){
                return false;
            }
        }
        return true;
    }
    public static boolean isSumAndProductMoreThanArg(int[] array, int argument){
        int sum = Arrays.stream(array).sum();
        int product = Arrays.stream(array).reduce(1, (a, b) -> a*b);
        return sum + product > argument;
    }
    // multiply all num param by 2 changes String param to "text"
    public static void changeParams(Human human){
        human.setName("text");
        human.setAge(human.getAge()*2);
        human.setSex("text");
    }
    public static List<Human> getALlHumanBySex(String sex){
        return Human.humans.values().stream().filter(h -> h.getSex().equals(sex))
                .toList();
    }
    public static List<Human> getALlHumanByAge(int age){
        return Human.humans.values().stream().filter(h -> h.getAge() > age)
                .toList();
    }
    public static int getAverageAge(){
        return Human.humans.values().stream().mapToInt(Human::getAge).reduce(0, Integer::sum)
                / Human.humans.size();
    }

}
