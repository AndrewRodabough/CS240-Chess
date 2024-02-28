package servceTests;

import model.UserData;
import model.AuthData;
import org.junit.jupiter.api.*;

public class Register {
    @Test
    public void RunPositive() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        AuthData auth = service.Register.Run(user);
        Assertions.assertNotNull(auth);
    }

    @Test
    public void RunNegative() {
        service.Clear.Run();
        UserData user = new UserData("bob", "password", "bob@bob.com");
        UserData user1 = new UserData("bob", "password1", "bob1@bob1.com");
        AuthData auth = service.Register.Run(user);
        AuthData auth1 = service.Register.Run(user1);
        Assertions.assertNull(auth1);
    }
}
