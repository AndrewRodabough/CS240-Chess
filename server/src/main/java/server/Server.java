package server;

import spark.*;
import handler.*;

public class Server {
    Handler clear = new Clear();
    Handler createGame = new CreateGame();
    Handler joinGame = new JoinGame();
    Handler listGames = new ListGames();
    Handler login = new Login();
    Handler logout = new Logout();
    Handler register = new Register();
    public int run(int desiredPort) {
        Spark.port(desiredPort);

        Spark.staticFiles.location("web");

        // Register your endpoints and handle exceptions here.
        Spark.delete("/db", this.clear::handler);
        Spark.post("/user", this.register::handler);
        Spark.post("/session", this.login::handler);
        Spark.delete("/session", this.logout::handler);
        Spark.get("/game", this.listGames::handler);
        Spark.post("/game", this.createGame::handler);
        Spark.put("/game", this.joinGame::handler);
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


    /*
    private void exceptionHandler(ResponseException ex, Request req, Response res) { res.status(ex.StatusCode()); }
     */
}
