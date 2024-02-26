package handler;

import spark.Request;
import spark.Response;

public interface Handler {
    Object handler(Request req, Response res);
}
