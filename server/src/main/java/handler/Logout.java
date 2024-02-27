package handler;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import model.AuthData;
import model.UserData;
import spark.Request;
import spark.Response;

public class Logout implements Handler {
    public Object handler(Request req, Response res) {

        String token = req.headers("authorization");

        boolean sucess = service.Logout.Run(token);
        res.status(sucess? 200 : 401);

        if (!sucess) {
            String message = "{\"message\": \"Error: unauthorized\"}";
            return new JsonParser().parse(message).getAsJsonObject();

        }
        return "";
    }
}