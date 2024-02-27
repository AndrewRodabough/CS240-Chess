package handler;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import model.GameData;
import service.Authorize;
import spark.Request;
import spark.Response;

public class JoinGame implements Handler {
    public Object handler(Request req, Response res) {
        String token = req.headers("authorization");
        boolean authorized = Authorize.Run(token);

        if(!authorized) {
            res.status(401);
            String message = "{\"message\": \"Error: unauthorized\"}";
            return new JsonParser().parse(message).getAsJsonObject();
        }

        JoinGameMessage message = new Gson().fromJson(req.body(), JoinGameMessage.class);

        if(message.gameID() == 0) {
            res.status(400);
            String message1 = "{\"message\": \"Error: bad request\"}";
            return new JsonParser().parse(message1).getAsJsonObject();
        }

        boolean status = service.JoinGame.Run(token, message.playerColor(), message.gameID());

        res.status(status? 200 : 403);
        if(!status) {
            String message2 = "{\"message\": \"Error: already taken\"}";
            return new JsonParser().parse(message2).getAsJsonObject();
        }
        else {
            return"";
        }
    }
    record JoinGameMessage(String playerColor, int gameID) {}
}
