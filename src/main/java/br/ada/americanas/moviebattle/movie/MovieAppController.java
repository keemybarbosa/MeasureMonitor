package br.ada.americanas.moviebattle.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/movies")
public class MovieAppController {

    private MovieService service;

    @Autowired
    public MovieAppController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("movies", service.list());
        return "movie/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie/form";
    }

    @PostMapping
    public String save(@ModelAttribute Movie movie) {
        service.add(movie);
        return "redirect:/app/movies";
    }

}
