package br.ada.americanas.moviebattle.player;

import br.ada.americanas.moviebattle.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/app/players")
public class PlayerAppController {
    private PlayerService service;

    @Autowired
    public PlayerAppController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public String get(Model model) {

        Iterable<Player> players = service.list();
        List<Player> sortedPlayers = StreamSupport.stream(players.spliterator(), false)
                .sorted(Comparator.comparingDouble(Player::getScore).reversed())
                .collect(Collectors.toList());

        model.addAttribute("players",
                sortedPlayers
        );
        return "player/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("player", new Player());
        return "player/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model
    ) {
        Player player = service.findById(id).get();
        model.addAttribute("player", player);
        return "player/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") Long id,
            Model model
    ) {
        service.delete(id);
        return "redirect:/app/players";
    }

    @PostMapping
    public String save(@ModelAttribute Player player) {
        service.add(player);
        return "redirect:/app/players";
    }

}
