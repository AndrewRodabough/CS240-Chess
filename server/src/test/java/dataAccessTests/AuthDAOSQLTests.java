package dataAccessTests;

import dataAccess.AuthDAOSQL;
import dataAccess.GameDAOSQL;
import dataAccess.UserDAOSQL;
import model.AuthData;
import org.junit.jupiter.api.*;

public class AuthDAOSQLTests {
    @Test
    public void createAuthPositive() {
        try {
            AuthDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            String authToken = AuthDAOSQL.createAuth("name");
            Assertions.assertNotNull(authToken);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
    @Test
    public void creatAuthNegative() {
        try {
            AuthDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            String authToken = AuthDAOSQL.createAuth(null);
            Assertions.fail();

        } catch (Exception e) {

        }
    }


    @Test
    public void getAuthPositive() {
        try {
            AuthDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            String authToken = AuthDAOSQL.createAuth("name");
            AuthData data = AuthDAOSQL.getAuth("name");
            Assertions.assertNotNull(data);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
    @Test
    public void getAuthNegative() {
        try {
            AuthDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            String authToken = AuthDAOSQL.createAuth("name");
            AuthData data = AuthDAOSQL.getAuth("wrong");
            Assertions.assertNull(data);
        } catch (Exception e) {

        }
    }


    @Test
    public void getAuthFromTokenPositive() {
        try {
            AuthDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            String authToken = AuthDAOSQL.createAuth("name");
            AuthData data = AuthDAOSQL.getAuthFromToken(authToken);
            Assertions.assertNotNull(data);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
    @Test
    public void getAuthFromTokenNegative() {
        try {
            AuthDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            String authToken = AuthDAOSQL.createAuth("name");
            AuthData data = AuthDAOSQL.getAuthFromToken("wrong");
            Assertions.assertNull(data);
        } catch (Exception e) {

        }
    }


    @Test
    public void deleteAuthPositive() {
        try {
            AuthDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            String authToken = AuthDAOSQL.createAuth("name");
            AuthDAOSQL.deleteAuth(authToken);
            Assertions.assertNull(AuthDAOSQL.getAuthFromToken(authToken));
        } catch (Exception e) {
            Assertions.fail();
        }
    }
    @Test
    public void deleteAuthNegative() {
        try {
            AuthDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            String authToken = AuthDAOSQL.createAuth("name");
            AuthDAOSQL.deleteAuth("wrong");
            Assertions.assertNotNull(AuthDAOSQL.getAuthFromToken(authToken));
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    public void clear() {
        try {
            Assertions.assertTrue(AuthDAOSQL.clear());
        }
        catch (Exception e) {
            Assertions.fail();
        }
    }
}
