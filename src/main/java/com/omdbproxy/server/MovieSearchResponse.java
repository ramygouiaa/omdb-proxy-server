package com.omdbproxy.server;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieSearchResponse {
    @JsonProperty("Search")
    private List<Movie> Search;

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Response")
    private String Response;

    public List<Movie> getSearch() {
        return Search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setSearch(List<Movie> search) {
        Search = search;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public static class Movie{

        @JsonProperty("Title")
        private String Title;

        @JsonProperty("Year")
        private String Year;

        @JsonProperty("imdbID")
        private String imdbID;

        @JsonProperty("Type")
        private String Type;

        @JsonProperty("Poster")
        private String Poster;

        public String getTitle() {
            return Title;
        }

        public String getYear() {
            return Year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public String getType() {
            return Type;
        }

        public String getPoster() {
            return Poster;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public void setYear(String year) {
            Year = year;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

        public void setType(String type) {
            Type = type;
        }

        public void setPoster(String poster) {
            Poster = poster;
        }
    }

}
