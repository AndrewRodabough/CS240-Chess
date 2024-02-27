package handler;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import model.GameData;
import model.UserData;
import service.Authorize;
import spark.Request;
import spark.Response;

public class CreateGame implements Handler {
    public Object handler(Request req, Response res) {
        String token = req.headers("authorization");
        boolean authorized = Authorize.Run(token);

        if (!authorized) {
            res.status(401);
            String message = "{\"message\": \"Error: unauthorized\"}";
            return new JsonParser().parse(message).getAsJsonObject();
        }

        GameData game = new Gson().fromJson(req.body(), GameData.class);
        int id = service.CreateGame.Run(game.gameName());

        res.status(200);
        String message = "{\"gameID\": \""+ id +"\"}";
        return new JsonParser().parse(message).getAsJsonObject();

    }
}
