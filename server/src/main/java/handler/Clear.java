package handler;

import spark.Request;
import spark.Response;

public class Clear implements Handler{
    public Object handler(Request req, Response res) {

        boolean result = service.Clear.Run();
        res.status(result? 200 : 500);
        return "{}";
    }
}

