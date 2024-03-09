package server;

import dataAccess.DatabaseManager;
import handler.Exception;
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
    Handler exception = new Exception();

    public int run(int desiredPort) {
        Spark.port(desiredPort);
        Spark.staticFiles.location("web");

        // Register your endpoints and handle exceptions here.
        Spark.delete("/db", (req, res) -> clear.handler(req,res));
        Spark.post("/user", (req, res) -> register.handler(req,res));
        Spark.post("/session", (req, res) -> login.handler(req,res));
        Spark.delete("/session", (req, res) -> logout.handler(req,res));
        Spark.get("/game", (req, res) -> listGames.handler(req,res));
        Spark.post("/game", (req, res) -> createGame.handler(req,res));
        Spark.put("/game", (req, res) -> joinGame.handler(req,res));
        //Spark.exception(server.ResponseException.class, (T, req, res) -> exception.handler(req, res));

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
}
