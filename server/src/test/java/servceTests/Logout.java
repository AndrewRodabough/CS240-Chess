package servceTests;

import model.AuthData;
import model.UserData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

public class Logout {
    @Test
    public void RunPositive() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        AuthData auth = service.Register.Run(user);
        Assertions.assertTrue(service.Logout.Run(auth.authToken()));

    }

    @Test
    public void RunNegative() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        AuthData auth = service.Register.Run(user);
        service.Logout.Run(auth.authToken());
        Assertions.assertFalse(service.Logout.Run(auth.authToken()));
    }
}
