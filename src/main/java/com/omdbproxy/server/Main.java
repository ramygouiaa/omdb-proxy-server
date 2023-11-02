package com.omdbproxy.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/movie")
public class Main {

    @GetMapping("{title}")
    public MovieSearchResponse getMoviesByTitle(@PathVariable("title") String title) throws
            URISyntaxException, IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://www.omdbapi.com/?apikey=fc73afe7&s=" + title)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(response.body(), MovieSearchResponse.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
