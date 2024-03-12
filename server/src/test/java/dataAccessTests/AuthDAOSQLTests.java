package dataAccessTests;

import dataAccess.AuthDAOSQL;
import dataAccess.UserDAOSQL;
import org.junit.jupiter.api.*;

public class AuthDAOSQLTests {
    @Test
    public void createAuthPositive() {

    }
    @Test
    public void creatAuthNegative() {

    }


    @Test
    public void getAuthPositive() {

    }
    @Test
    public void getAuthNegative() {

    }


    @Test
    public void getAuthFromTokenPositive() {

    }
    @Test
    public void getAuthFromTokenNegative() {

    }


    @Test
    public void deleteAuthPositive() {

    }
    @Test
    public void deleteAuthNegative() {

    }


    @Test
    public void clearPositive() {

    }
    @Test
    public void clearNegative() {
        try {
            Assertions.assertTrue(AuthDAOSQL.clear());
        }
        catch (Exception e) {
            Assertions.fail();
        }
    }
}
