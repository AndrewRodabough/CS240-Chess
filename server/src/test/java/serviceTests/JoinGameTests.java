package serviceTests;

import model.AuthData;
import model.GameData;
import model.UserData;
import org.junit.jupiter.api.*;

import java.util.Collection;

public class JoinGameTests {
    @Test
    public void RunPositive() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        AuthData auth = service.Register.Run(user);
        int id = service.CreateGame.Run("game");
        Assertions.assertNotNull(auth);
        service.JoinGame.Run(auth.authToken(), "WHITE", id);
        Collection<GameData> games = service.ListGames.Run();
        for(GameData game: games) {
            if(game.gameID() == id) {
                Assertions.assertEquals(game.whiteUsername(), user.username());
                return;
            }
        }
        Assertions.fail();
    }

    @Test
    public void RunNegative() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        UserData user1 = new UserData("bob1", "password", "bob@bob.com");

        AuthData auth = service.Register.Run(user);
        AuthData auth1 = service.Register.Run(user1);

        Assertions.assertNotNull(auth);
        Assertions.assertNotNull(auth1);

        int id = service.CreateGame.Run(auth.authToken());

        service.JoinGame.Run(auth.authToken(), "WHITE", id);
        boolean joined = service.JoinGame.Run(auth1.authToken(), "WHITE", id);

        Assertions.assertFalse(joined);
    }
}
