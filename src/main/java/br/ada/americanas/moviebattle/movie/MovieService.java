package br.ada.americanas.moviebattle.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie add(Movie movie) {
        return this.repository.save(movie);
    }

    public Movie update(Movie movie) {
        return this.repository.save(movie);
    }

    public Iterable<Movie> list() {
        return this.repository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return this.repository.findById(id);
    }

    public Optional<Movie> delete(Long id) {
        Optional<Movie> deleted = findById(id);
        this.repository.deleteById(id);
        return deleted;
    }

}
