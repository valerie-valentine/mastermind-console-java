package model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CodeMaker {
    private String[] secretCode;

    public CodeMaker(int codeLength) {
        this.secretCode = this.fetchSecretCodeAPI(codeLength);

    }

    private String[] fetchSecretCodeAPI (int codelength) {
        // Generic class that requires a type argument indicating the type of the response
        HttpResponse<String> response = null;
        HttpClient client = HttpClient.newHttpClient();
        String baseUrl = "https://www.random.org/integers/?num=" + codelength + "&min=0&max=9&col=1&base=10&format=plain&rnd=new";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl))
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("Error occurred while connecting to the randomNumber API: " + e.getMessage());
            return null;
        }

        if (response != null){
            String body = response.body();
            // splitting into an array of strings here while splitting the response by line breaks
            return body.split("\\R");
            // have to use wrapper class method
//            System.out.println(Arrays.toString(result));
        }
        return null;
    }

    public void setSecretCode(String[] code) {
        this.secretCode = code;
    }

    public String[] getSecretCode() {
        return this.secretCode;
    }

}

// Note: handle explicitly printing out the correct errors and then use a catch all.
// For example: when the api in unavailable 503 - overloaded
