package handler;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import service.Authorize;
import spark.Request;
import spark.Response;

public class JoinGame implements Handler {
    public Object handler(Request req, Response res) {
        String message;

        // authorize the user with authorize service
        String token = req.headers("authorization");
        boolean authorized = Authorize.Run(token);

        if(!authorized) {
            // not authorized
            res.status(401);
            message = "{\"message\": \"Error: unauthorized\"}";
        }
        else {
            // authorized

            // parse json
            JoinGameRequest request = new Gson().fromJson(req.body(), JoinGameRequest.class);

            if(request.gameID() == 0) {
                // request invalid (game id not provided)
                res.status(400);
                message = "{\"message\": \"Error: bad request\"}";
            }
            else {
                // request valid

                // run service
                boolean status = service.JoinGame.Run(token, request.playerColor(), request.gameID());

                res.status(status? 200 : 403);
                if(!status) {
                    // service ran unsuccessfully
                    message = "{\"message\": \"Error: already taken\"}";
                }
                else {
                    // service ran successfully
                    return"{}";
                }
            }
        }

        // return message as json
        return new JsonParser().parse(message).getAsJsonObject();
    }
    record JoinGameRequest(String playerColor, int gameID) {}
}
