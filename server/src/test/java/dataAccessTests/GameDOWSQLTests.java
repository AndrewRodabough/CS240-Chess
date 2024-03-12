package dataAccessTests;

import dataAccess.GameDAOSQL;
import dataAccess.UserDAOSQL;
import org.junit.jupiter.api.*;

public class GameDOWSQLTests {
    @Test
    public void createGamePositive() {

    }
    @Test
    public void creatGameNegative() {

    }


    @Test
    public void getGamePositive() {

    }
    @Test
    public void getGameNegative() {

    }


    @Test
    public void listGamePositive() {

    }
    @Test
    public void listGameNegative() {

    }


    @Test
    public void updateGameUserPositive() {

    }
    @Test
    public void updateGameUserNegative() {

    }

    @Test
    public void clearPositive() {
        try {
            Assertions.assertTrue(GameDAOSQL.clear());
        }
        catch (Exception e) {
            Assertions.fail();
        }
    }
}
