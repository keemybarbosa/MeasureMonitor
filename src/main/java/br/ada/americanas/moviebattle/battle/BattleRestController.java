package br.ada.americanas.moviebattle.battle;

import br.ada.americanas.moviebattle.movie.Movie;
import br.ada.americanas.moviebattle.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/battles")
public class BattleRestController {

    private BattleService service;

    @Autowired
    public BattleRestController(BattleService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Battle create(@RequestBody Battle battle) {
        return this.service.create(battle.getPlayer());
    }


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Iterable<Battle> list() {
        return service.list();
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Battle get(@PathVariable("id") Long id) {
        return this.service.findById(id).get();
    }

}
