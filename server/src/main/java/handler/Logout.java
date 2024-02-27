package handler;

import com.google.gson.JsonParser;
import spark.Request;
import spark.Response;

public class Logout implements Handler {
    public Object handler(Request req, Response res) {

        String token = req.headers("authorization");

        //run service
        boolean success = service.Logout.Run(token);

        res.status(success? 200 : 401);
        if (!success) {
            // invalid authToken
            String message = "{\"message\": \"Error: unauthorized\"}";
            return new JsonParser().parse(message).getAsJsonObject();
        }
        // successful logout
        return "";
    }
}