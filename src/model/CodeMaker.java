package model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class CodeMaker {
    private String[] secretcode;
    int codelength;

//   public CodeMaker(int codeLength) {
//        this.codelength = codeLength;
//    }

    // Generic class that requires a type argument indicating the type of the response
    public String[] setSecretCode () {
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
            // splitting into an array of strings here while splitting the response by line breaks
            String[] result = body.split("\\R");
            // have to use wrapper class method
            System.out.println(Arrays.toString(result));
            return result;
        }
        return null;
    }


}
