package server;

import server.websocket.WebSocketHandler;

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
        Spark.post("/user", this::CreateGameHandler);
        Spark.post("/user", this::LoginHandler);
        Spark.post("/user", this::RegistrationHandler);
        Spark.get("/user", this::JoinGameHandler);
        Spark.get("/user", this::ListGamesHandler);
        Spark.delete("/user", this::ClearApplicationHandler);
        Spark.delete("/user", this::LogoutHandler);
        //Spark.exception(ResponseException.class, this::exceptionHandler);

        Spark.awaitInitialization();
        return Spark.port();
    }

    public int port() {
        return Spark.port();
    }
    public void stop() {
        Spark.stop();
        Spark.awaitStop();
    }

    private Object ClearApplicationHandler(Request req, Response res) {
        return "Not Implemented";
    }
    private Object CreateGameHandler(Request req, Response res) {
        return "Not Implemented";
    }
    private Object JoinGameHandler(Request req, Response res) {
        return "Not Implemented";
    }
    private Object ListGamesHandler(Request req, Response res) {
        return "Not Implemented";
    }
    private Object LoginHandler(Request req, Response res) {
        return "Not Implemented";
    }
    private Object LogoutHandler(Request req, Response res) {
        return "Not Implemented";
    }
    private Object RegistrationHandler(Request req, Response res) {
        return "Not Implemented";
    }

    /*
    private void exceptionHandler(ResponseException ex, Request req, Response res) { res.status(ex.StatusCode()); }
     */
}
