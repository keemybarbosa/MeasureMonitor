package br.ada.americanas.measuremonitor.measure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/measure")
public class MeasureRestController {

    private MeasureService service;

    @Autowired
    public MeasureRestController(MeasureService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Measure create(@RequestBody Measure measure) {
        return this.service.add(measure);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Measure update(
            @PathVariable("id") Long id,
            @RequestBody Measure measure
    ) {
        measure.setId(id);
        return this.service.update(measure);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Iterable<Measure> list() {
        return service.list();
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Measure get(@PathVariable("id") Long id) {
        return this.service.findById(id).get();
    }

    @GetMapping(
            value = "/last",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Measure get() {
        return this.service.findLatestMeasure();
    }
    @DeleteMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Measure delete(@PathVariable("id") Long id) {
        return service.delete(id).get();
    }

}
