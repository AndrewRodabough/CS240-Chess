package handler;

import model.UserData;
import model.AuthData;
import spark.Request;
import spark.Response;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

public class Register implements Handler {
    public Object handler(Request req, Response res) {

        // parse json
        UserData user = new Gson().fromJson(req.body(), UserData.class);

        if(user.username() == null || user.email() == null || user.password() == null) {
            // invalid request
            res.status(400);
            String message = "{\"message\": \"Error: bad request\"}";
            return new JsonParser().parse(message).getAsJsonObject();
        }

        //run service
        AuthData auth = service.Register.Run(user);

        res.status(auth == null ? 403 : 200);
        if(auth == null) {
            // user taken
            String message = "{\"message\": \"Error: already taken\"}";
            return new JsonParser().parse(message).getAsJsonObject();
        }

        // successfully registered
        return new Gson().toJson(auth);
    }
}
