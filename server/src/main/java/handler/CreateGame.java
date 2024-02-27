package handler;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import model.GameData;
import service.Authorize;
import spark.Request;
import spark.Response;

public class CreateGame implements Handler {
    public Object handler(Request req, Response res) {
        String message;

        // authorize the user with authorize service
        String token = req.headers("authorization");
        boolean authorized = Authorize.Run(token);

        if (!authorized) {
            // not authorized
            res.status(401);
            message = "{\"message\": \"Error: unauthorized\"}";
        }
        else {
            //authorized

            // parse json and run service
            GameData game = new Gson().fromJson(req.body(), GameData.class);
            int id = service.CreateGame.Run(game.gameName());
            if(id > 0) {
                // game is created
                res.status(200);
                message = "{\"gameID\": \""+ id +"\"}";
            }
            else {
                // game not created
                res.status(500);
                message = "{\"message\": \"Error: unable to create game\"}";
            }
        }

        // return message as json
        return new JsonParser().parse(message).getAsJsonObject();
    }
}
