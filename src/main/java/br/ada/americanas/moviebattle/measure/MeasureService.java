package br.ada.americanas.moviebattle.measure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Measure add(Measure player) {
        return this.repository.save(player);
    }

    public Measure update(Measure player) {
        return this.repository.save(player);
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
