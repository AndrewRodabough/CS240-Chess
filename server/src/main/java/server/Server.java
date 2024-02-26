package server;

import spark.*;

public class Server {

    public int run(int desiredPort) {
        Spark.port(desiredPort);

        Spark.staticFiles.location("web");

        // Register your endpoints and handle exceptions here.
        Spark.delete("/db", this::ClearApplicationHandler);
        Spark.post("/user", this::RegisterHandler);
        Spark.post("/session", this::LoginHandler);
        Spark.delete("/session", this::LogoutHandler);
        Spark.get("/game", this::ListGamesHandler);
        Spark.post("/game", this::CreateGameHandler);
        Spark.put("/game", this::JoinGameHandler);
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
    private Object RegisterHandler(Request req, Response res) {
        return "Not Implemented";
    }

    /*
    private void exceptionHandler(ResponseException ex, Request req, Response res) { res.status(ex.StatusCode()); }
     */
}
