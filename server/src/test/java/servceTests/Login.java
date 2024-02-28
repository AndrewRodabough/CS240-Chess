package servceTests;

import model.AuthData;
import model.UserData;
import org.junit.jupiter.api.*;

public class Login {
    @Test
    public void RunPositive() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        AuthData auth = service.Register.Run(user);
        service.Logout.Run(auth.authToken());
        auth = service.Login.Run(user);
        Assertions.assertNotNull(auth.authToken());
    }

    @Test
    public void RunNegative() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        UserData user1 = new UserData("basob", "passworad", "boba@bob.com");
        AuthData auth = service.Register.Run(user);
        service.Logout.Run(auth.authToken());
        auth = service.Login.Run(user1);
        Assertions.assertNull(auth);
    }
}
