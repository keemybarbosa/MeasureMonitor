package br.ada.americanas.measuremonitor.measure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MeasureService {
    private MeasureRepository repository;

    @Autowired
    public MeasureService(MeasureRepository repository) {
        this.repository = repository;
    }

    public Measure add(Measure measure) {
        return this.repository.save(measure);
    }

    public Measure update(Measure measure) {
        return this.repository.save(measure);
    }

    public Iterable<Measure> list() {
        return this.repository.findAll();
    }

    public Optional<Measure> findById(Long id) {
        return this.repository.findById(id);
    }

    public Measure findLatestMeasure() {
        List<Measure> measures = (List<Measure>) this.repository.findAll();
        if (!measures.isEmpty()) {
            measures.sort(Comparator.comparing(Measure::getDateTime).reversed());
            return measures.get(0);
        }
        return null;
    }

    public Optional<Measure> delete(Long id) {
        Optional<Measure> deleted = findById(id);
        this.repository.deleteById(id);
        return deleted;
    }
}
