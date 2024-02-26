package server;

import com.google.gson.Gson;
import dataAccess.DataAccess;
import server.websocket.WebSocketHandler;
import service.Service;

import spark.*;

public class Server {

    private final WebSocketHandler webSocketHandler;

    public Server() {
        webSocketHandler = new WebSocketHandler();
    }

    public int run(int desiredPort) {
        Spark.port(desiredPort);

        Spark.staticFiles.location("web");

        // Register your endpoints and handle exceptions here.
        Spark.post("/chess", this::CreateGameHandler);
        Spark.post("/chess", this::LoginHandler);
        Spark.post("/chess", this::RegistrationHandler);
        Spark.get("/chess", this::JoinGameHandler);
        Spark.get("/chess", this::ListGamesHandler);
        Spark.delete("/chess", this::ClearApplicationHandler);
        Spark.delete("/chess", this::LogoutHandler);

        Spark.awaitInitialization();
        return Spark.port();
    }

    public int port() {
        return Spark.port();
    }
    public void stop() { Spark.stop(); Spark.awaitStop(); }

    private Object ClearApplicationHandler(Request req, Response res) {

    }
    private Object CreateGameHandler(Request req, Response res) {

    }
    private Object JoinGameHandler(Request req, Response res) {

    }
    private Object ListGamesHandler(Request req, Response res) {

    }
    private Object LoginHandler(Request req, Response res) {

    }
    private Object LogoutHandler(Request req, Response res) {

    }
    private Object RegistrationHandler(Request req, Response res) {

    }
}
