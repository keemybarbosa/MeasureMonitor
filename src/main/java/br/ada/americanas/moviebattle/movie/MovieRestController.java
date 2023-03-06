package br.ada.americanas.moviebattle.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    private MovieService service;

    @Autowired
    public MovieRestController(MovieService service) {
        this.service = service;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Movie create(@RequestBody Movie movie) {
        return this.service.add(movie);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Movie> list() {
        return service.list();
    }

}
