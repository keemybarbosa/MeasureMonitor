package br.ada.americanas.moviebattle.movie;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    private Map<Long, Movie> movies = new HashMap<>();

    public MovieService() {
    }

    public Movie add(Movie movie) {
        this.movies.put(movie.getId(), movie);
        return movie;
    }

    public Movie update(Movie movie) {
        this.movies.put(movie.getId(), movie);
        return movie;
    }

    public List<Movie> list() {
        return new ArrayList<>(this.movies.values());
    }

}
