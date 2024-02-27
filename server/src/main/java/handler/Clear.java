package handler;

import spark.Request;
import spark.Response;
import com.google.gson.Gson;

public class Clear implements Handler{
    public Object handler(Request req, Response res) {

        Boolean result = (Boolean) service.Clear.Run();
        res.status(result? 200 : 500);
        res.type("application/json");
        return "{ \"message\": \"Error: unauthorized\" }";
    }
}

