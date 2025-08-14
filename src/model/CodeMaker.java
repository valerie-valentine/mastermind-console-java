package model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CodeMaker {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static String[] generateRandomCode (int codelength) {
        HttpResponse<String> response = null;
        String baseUrl = "https://www.random.org/integers/?num=" + codelength + "&min=0&max=9&col=1&base=10&format=plain&rnd=new";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl))
                    .build();

            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("Error occurred while connecting to the randomNumber API: " + e.getMessage());
            return null;
        }
        if (response.statusCode() == 200) {
            String body = response.body();
            // splitting into an array of strings here while splitting the response by line breaks
            return body.split("\\R");
        } else {
            System.out.println("Error: Random Number API Service unavailable. Status Code: " + response.statusCode() + ".");
            return null;
        }
    }
}

