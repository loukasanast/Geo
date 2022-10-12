package io.anastasiou;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connect {
    private final String url;

    public Connect(String q) {
        this.url = "https://geocode.search.hereapi.com/v1/" +
                "geocode" +
                "?q=" + q.replace(" ", "+") +
                "&apiKey=L_yYiBEa58JcB3T6GY6htDYL_YzpABkcAbt1Y9xyOQc";
    }

    public Parser.Location getData() {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .build();

        try {
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            Parser parser = new Parser(res.body());

            return parser.getLocation();
        } catch(IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
