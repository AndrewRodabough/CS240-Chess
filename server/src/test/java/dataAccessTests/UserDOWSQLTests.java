package dataAccessTests;

import dataAccess.UserDAOSQL;
import model.UserData;
import org.junit.jupiter.api.*;

public class UserDOWSQLTests {
    @Test
    public void createUserPositive() {
        try {
            UserData data = new UserData("bob", "password", "bob@bob.com");
            UserDAOSQL.createUser(data);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
    @Test
    public void creatUserNegative() {
        try {
            UserDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            UserData data = null;
            UserDAOSQL.createUser(data);
            Assertions.fail();
        } catch (Exception e) {

        }
    }


    @Test
    public void getUserPositive() {
        try {
            UserDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            UserData data = new UserData("bob", "password", "bob@bob.com");
            UserDAOSQL.createUser(data);
            String username = UserDAOSQL.getUser(data.username()).username();
            Assertions.assertEquals(data.username(), username);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
    @Test
    public void getUserNegative() {
        try {
            UserDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            UserData data = new UserData("bob", "password", "bob@bob.com");
            UserDAOSQL.createUser(data);
            UserData data1 = UserDAOSQL.getUser("");
            Assertions.assertNull(data1);
        } catch (Exception e) {
            Assertions.fail();
        }
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
