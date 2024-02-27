package handler;

import com.google.gson.JsonParser;
import spark.Request;
import spark.Response;
import com.google.gson.Gson;

public class Clear implements Handler{
    public Object handler(Request req, Response res) {

        boolean result = service.Clear.Run();
        res.status(result? 200 : 500);
        res.type("application/json");
        return "";
    }
}

