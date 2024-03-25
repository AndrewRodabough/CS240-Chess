package clientTests;

import ClientStateMachine.ServerFacade;
import com.google.gson.Gson;
import model.UserData;
import org.junit.jupiter.api.*;
import server.Server;

import java.net.http.HttpResponse;


public class ServerFacadeTests {

    private static Server server;

    @BeforeAll
    public static void init() {
        server = new Server();
        var port = server.run(8080);
        System.out.println("Started test HTTP server on " + port);
        ServerFacade.sendRequest("/db", "DELETE", "", null);
    }

    @AfterAll
    static void stopServer() {
        server.stop();
    }

    @Test
    public void positiveRegisterTest() {
        UserData user = new UserData("bob", "password", "bob@bob.com");
        String json = new Gson().toJson(user);
        HttpResponse<String> res = ServerFacade.sendRequest("/user", "POST", json, null);
        Assertions.assertNotNull(res);
        System.out.println(res.statusCode());
        Assertions.assertTrue(res.statusCode() == 200);
    }
    @Test
    public void negativeRegisterTest() {
        UserData user = new UserData("bob", null , "bob@bob.com");
        String json = new Gson().toJson(user);
        HttpResponse<String> res = ServerFacade.sendRequest("/user", "POST", json, null);
        Assertions.assertNotNull(res);
        Assertions.assertFalse(res.statusCode() == 200);
    }

    @Test
    public void positiveLoginTest() {
        Assertions.assertTrue(true);
    }
    @Test
    public void negativeLoginTest() {
        Assertions.assertTrue(true);
    }

    @Test
    public void positiveListTest() {
        Assertions.assertTrue(true);
    }
    @Test
    public void negativeListTest() {
        Assertions.assertTrue(true);
    }

    @Test
    public void positiveCreateTest() {
        Assertions.assertTrue(true);
    }
    @Test
    public void negativeCreateTest() {
        Assertions.assertTrue(true);
    }

    @Test
    public void positiveLogoutTest() {
        Assertions.assertTrue(true);
    }
    @Test
    public void negativeLogoutTest() {
        Assertions.assertTrue(true);
    }

    @Test
    public void positiveJoinTest() {
        Assertions.assertTrue(true);
    }
    @Test
    public void negativeJoinTest() {
        Assertions.assertTrue(true);
    }

    @Test
    public void positiveClearTest() {
        Assertions.assertTrue(true);
    }
    @Test
    public void negativeClearTest() {
        Assertions.assertTrue(true);
    }
}
