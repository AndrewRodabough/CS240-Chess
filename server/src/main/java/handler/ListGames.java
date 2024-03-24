package handler;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import model.GameData;
import service.Authorize;
import spark.Request;
import spark.Response;

import java.util.Collection;

public class ListGames implements Handler {
    public Object handler(Request req, Response res) {
        // authorize the user with authorize service
        String token = req.headers("authorization");
        boolean authorized = Authorize.Run(token);

        if (!authorized) {
            // unauthorized
            res.status(401);
            String message = "{\"message\": \"Error: unauthorized\"}";
            return new JsonParser().parse(message).getAsJsonObject();
        }

        // run service
        Collection<GameData> game = service.ListGames.Run();

        if(game == null) {
            // games not returned
            res.status(500);
            String message = "{\"message\": \"Error: games is null\"}";
            return new JsonParser().parse(message).getAsJsonObject();
        }
        else {
            // games returned successfully
            res.status(200);
            return new Gson().toJson(new games(game));
        }
    }

    public record games(Collection<GameData> games) {
    }
}
