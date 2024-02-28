package servceTests;

import dataAccess.AuthDAOMemory;
import dataAccess.UserDAOMemory;
import org.junit.jupiter.api.*;

public class Clear {
    @Test
    public void RunPositive() {
        Assertions.assertTrue(service.Clear.Run());
    }
}
