package org.example.task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.print.attribute.standard.JobHoldUntil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    public   Human humanOne;
    public   Human humanTwo;
    public   Human humanThree;





    @Before
    public void setUp(){
        humanOne = new Human("ab", 1, "male");
        humanTwo = new Human("ba", 2, "female");
        humanThree = new Human("xyz", 3, "male");



    }

    @Test
    public void getBiggestOfTwo() {
        int expected = 30;
        int actual = Main.getBiggestOfTwo(3, 30);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isAlphabetical(){
        Boolean expected = true;
        boolean actual = Main.isAlphabetical("abc");
    }
    @Test
    public void isSumAndProductMoreThanArg(){
        boolean expected = true;
        boolean actual = Main.isSumAndProductMoreThanArg(Main.array, 1);
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void changeParams(){
        Human expected = new Human("text", 4, "text");
        Main.changeParams(humanTwo);
        Human actual = humanTwo;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getALlHumanBySex(){
        List<Human> expected = new ArrayList<>();
        expected.add(humanTwo);
        List<Human> actual = Main.getALlHumanBySex("female");
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getALlHumanByAge(){
        List<Human> expected = new ArrayList<>();
        expected.add(humanThree);
        List<Human> actual = Main.getALlHumanByAge(2);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getAverageAge(){
        int expected = 2;
        int actual = Main.getAverageAge();
        Assert.assertEquals(expected, actual);

    }






}