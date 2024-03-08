package serviceTests;

import org.junit.jupiter.api.*;

public class ClearTests {
    @Test
    public void RunPositive() {
        Assertions.assertTrue(service.Clear.Run());
    }
}
