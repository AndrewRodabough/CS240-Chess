package handler;

import chess.ChessGame;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import model.GameData;
import model.UserData;
import service.Authorize;
import spark.Request;
import spark.Response;

import java.util.Collection;

public class ListGames implements Handler {
    public Object handler(Request req, Response res) {
        String token = req.headers("authorization");
        boolean authorized = Authorize.Run(token);

        res.status(authorized? 200 : 401);
        if (!authorized) {
            String message = "{\"message\": \"Error: unauthorized\"}";
            return new JsonParser().parse(message).getAsJsonObject();
        }
        Collection<GameData> games = service.ListGames.Run();
        return new Gson().toJson(games);
    }
}
