package dataAccessTests;

import dataAccess.GameDAOSQL;
import dataAccess.UserDAOSQL;
import model.GameData;
import model.UserData;
import org.junit.jupiter.api.*;

import java.util.Collection;

public class GameDOWSQLTests {
    @Test
    public void createGamePositive() {
        try {
            GameDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            GameDAOSQL.createGame("name");
        } catch (Exception e) {
            Assertions.fail();
        }
    }
    @Test
    public void creatGameNegative() {
        try {
            GameDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            Assertions.assertEquals(GameDAOSQL.createGame(null),-1);
        } catch (Exception e) {
            Assertions.fail();
        }
    }


    @Test
    public void getGamePositive() {
        try {
            GameDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            int id = GameDAOSQL.createGame("name");
            GameData data = GameDAOSQL.getGame(id);
            Assertions.assertNotNull(data);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
    @Test
    public void getGameNegative() {
        try {
            GameDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            int id = GameDAOSQL.createGame("name");
            GameData data = GameDAOSQL.getGame(0);
            Assertions.assertNull(data);
        } catch (Exception e) {
            Assertions.fail();
        }
    }


    @Test
    public void listGamePositive() {
        try {
            GameDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            GameDAOSQL.createGame("game");
            Collection<GameData> data = GameDAOSQL.listGames();
            Assertions.assertFalse(data.isEmpty());
        } catch (Exception e) {
            Assertions.fail();
        }
    }
    @Test
    public void listGameNegative() {
        try {
            GameDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            Collection<GameData> data = GameDAOSQL.listGames();
            Assertions.assertTrue(data.isEmpty());
        } catch (Exception e) {
            Assertions.fail();
        }
    }


    @Test
    public void updateGameUserPositive() {
        try {
            GameDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            int id = GameDAOSQL.createGame("name");
            GameDAOSQL.updateGameUser(id,"HEllo",null);
            GameData game = GameDAOSQL.getGame(id);
            Assertions.assertEquals(game.whiteUsername(), "HEllo");
        } catch (Exception e) {
            Assertions.fail();
        }
    }
    @Test
    public void updateGameUserNegative() {
        try {
            GameDAOSQL.clear();
        }
        catch (Exception e) {
            Assertions.fail();
        }
        try {
            int id = GameDAOSQL.createGame("name");
            GameDAOSQL.updateGameUser(id,null,null);
            GameData game = GameDAOSQL.getGame(id);
            Assertions.assertEquals(game.whiteUsername(), null);
        } catch (Exception e) {
            Assertions.fail();
        }
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
