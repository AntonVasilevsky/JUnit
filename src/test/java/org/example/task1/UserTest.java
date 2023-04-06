package org.example.task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserTest {
    private User user1;
    private User user2;
    private User user3;
    private User notAdd;
    private User notAdd2;
    public static int counter = 0;

    @Before
    public void setup(){
        user1  = new User("a", 1, Sex.MALE);
        user2  = new User("b", 2, Sex.FEMALE);
        user3  = new User("c", 3, Sex.MALE);
        notAdd = new User("", 0, null);
        notAdd2 = new User(null, 0, null);


    }



    @Test
    public void getAllUsersNotNull(){

        List<User> expected = User.getAllUsers();


        Assert.assertNotNull(expected);
    }
    @Test
    public void testNewUserEmptyName(){
        for (User user : User.getAllUsers()
             ) {
            if(user.getName() == null || user.getName().isEmpty())
                Assert.fail("Trying to create user with empty name");
        }
    }

    @Test
    public void testGetAllUsers() {

        List<User> expected = User.getAllUsers();
        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);
        actual.add(user3);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testGetHowManyUsers_FEMALE() {

        int expected = 1;
        int actual = User.getHowManyUsers(Sex.FEMALE);
        Assert.assertEquals(expected,actual);
    }



    @Test
    public void testGetAllAgeUsers() {

        int actual  = 1+2+3;
        int expected = User.getAllAgeUsers();
        Assert.assertEquals(expected, actual);

    }




    @Test
    public void testGetAverageAge() {
        int expected = (1+2+3)/3;
        int actual = User.getAverageAge();
    }
}