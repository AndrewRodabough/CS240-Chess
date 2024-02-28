package servceTests;

import model.AuthData;
import model.GameData;
import model.UserData;
import org.junit.jupiter.api.*;

import java.util.Collection;

public class CreateGame {
    @Test
    public void RunPositive() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        AuthData auth = service.Register.Run(user);
        int id = service.CreateGame.Run("game");
        Collection<GameData> games = service.ListGames.Run();
        for(GameData game: games) {
            if(game.gameID() == id) {
                return;
            }
        }
        Assertions.assertFalse(true);
    }

    @Test
    public void RunNegative() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        AuthData auth = service.Register.Run(user);
        int id = service.CreateGame.Run(null);
        Collection<GameData> games = service.ListGames.Run();
        Assertions.assertTrue(games.isEmpty());
    }
}
