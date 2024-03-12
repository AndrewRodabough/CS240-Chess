package dataAccessTests;

import dataAccess.UserDAOSQL;
import org.junit.jupiter.api.*;

public class UserDOWSQLTests {
    @Test
    public void createUserPositive() {

    }
    @Test
    public void creatUserNegative() {

    }


    @Test
    public void getUserPositive() {

    }
    @Test
    public void getUserNegative() {

    }


    @Test
    public void clearPositive() {
        try {
            Assertions.assertTrue(UserDAOSQL.clear());
        }
        catch (Exception e) {
            Assertions.fail();
        }
    }
}
