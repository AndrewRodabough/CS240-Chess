package ClientStateMachine;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class HTTPHandler {
    static HttpClient client = HttpClient.newHttpClient();

    public static HttpResponse<String> sendRequest(String endpoint, String method, String requestBody) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080" + endpoint))
                .method(method, HttpRequest.BodyPublishers.ofString(requestBody));

        // Set Content-Type header for POST and PUT requests
        if (method !=null && (method.equals("POST") || method.equals("PUT"))) {
            requestBuilder.setHeader("Content-Type", "application/json");
        }

        HttpRequest request = requestBuilder.build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

}
