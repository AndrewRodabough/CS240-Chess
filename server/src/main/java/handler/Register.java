package handler;

import model.UserData;
import model.AuthData;
import spark.Request;
import spark.Response;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Register implements Handler {
    public Object handler(Request req, Response res) {
        UserData user = new Gson().fromJson(req.body(), UserData.class);

        if(user.username() == null || user.email() == null || user.password() == null) {
            res.status(400);
            String message = "{\"message\": \"Error: bad request\"}";
            return new JsonParser().parse(message).getAsJsonObject();
        }

        AuthData auth = service.Register.Run(user);
        res.status(auth == null ? 403 : 200);

        if(auth == null) {
            String message = "{\"message\": \"Error: already taken\"}";
            return new JsonParser().parse(message).getAsJsonObject();
        }
        return new Gson().toJson(auth);

        /*
        UserData user = new Gson().fromJson(req.body(), UserData.class);
        AuthData auth = service.Register.Run(user);
        res.status(auth == null ? 403 : 200);
        if(auth == null) {
            String message = "{\"message\": \"Error: already taken\"}";
            //res.body(message);
            return new JsonParser().parse(message).getAsJsonObject();
            //return new Gson().toJson(res.body());
        }
        else {
            //res.body(new Gson().toJson(auth));
            return new Gson().toJson(auth);
        }
         */
    }
}
