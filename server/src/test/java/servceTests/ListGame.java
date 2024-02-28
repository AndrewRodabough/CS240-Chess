package servceTests;

import model.AuthData;
import model.GameData;
import model.UserData;
import org.junit.jupiter.api.*;

import java.util.Collection;

public class ListGame {
    @Test
    public void RunPositive() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        AuthData auth = service.Register.Run(user);
        service.CreateGame.Run("game");
        Collection<GameData> games = service.ListGames.Run();
        Assertions.assertFalse(games.isEmpty());
    }

    @Test
    public void RunNegative() {
        service.Clear.Run();
        Collection<GameData> games = service.ListGames.Run();
        Assertions.assertTrue(games.isEmpty());
    }
}
