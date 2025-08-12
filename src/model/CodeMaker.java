package model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CodeMaker {
    private char[] secretcode;
    int codelength;

//   public CodeMaker(int codeLength) {
//        this.codelength = codeLength;
//    }

    // Generic class that requires a type argument indicating the type of the response
    public String setSecretCode () {
        HttpResponse<String> response = null;
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.random.org/integers/?num=4&min=0&max=9&col=1&base=10&format=plain&rnd=new"))
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.printf("Error occurred while connecting to the randomNumber API: " + e.getMessage());
            return null;
        }

        if (response != null){
            String body = response.body();
            System.out.println(body);
            return body;
        }
        return null;
    }


}
