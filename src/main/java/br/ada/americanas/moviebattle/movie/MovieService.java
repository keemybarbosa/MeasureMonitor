package br.ada.americanas.moviebattle.movie;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public MovieService() {
    }

    public Movie add(Movie movie) {
        this.movies.add(movie);
        return movie;
    }

    public List<Movie> list() {
        return Collections.unmodifiableList(this.movies);
    }

}
