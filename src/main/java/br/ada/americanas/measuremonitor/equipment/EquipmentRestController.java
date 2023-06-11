package br.ada.americanas.measuremonitor.equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentRestController {

    private EquipmentService service;

    @Autowired
    public EquipmentRestController(EquipmentService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Equipment create(@RequestBody Equipment equipment) {
        return this.service.add(equipment);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Equipment update(
            @PathVariable("id") Long id,
            @RequestBody Equipment equipment
    ) {
        equipment.setId(id);
        return this.service.update(equipment);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Iterable<Equipment> list() {
        return service.list();
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Equipment get(@PathVariable("id") Long id) {
        return this.service.findById(id).get();
    }


    @DeleteMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Equipment delete(@PathVariable("id") Long id) {
        return service.delete(id).get();
    }

}
