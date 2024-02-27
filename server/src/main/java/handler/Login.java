package handler;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import model.AuthData;
import model.UserData;
import spark.Request;
import spark.Response;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Login implements Handler {
    public Object handler(Request req, Response res) {
        UserData user = new Gson().fromJson(req.body(), UserData.class);

        AuthData auth = service.Login.Run(user);
        res.status(auth == null? 401 : 200);
        if (auth != null) {
            return new Gson().toJson(auth);
        }
        String message = "{\"message\": \"Error: unauthorized\"}";
        return new JsonParser().parse(message).getAsJsonObject();
    }
}
