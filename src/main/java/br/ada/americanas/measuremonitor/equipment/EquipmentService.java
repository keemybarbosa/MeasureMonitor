package br.ada.americanas.measuremonitor.equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    private EquipmentRepository repository;

    @Autowired
    public EquipmentService(EquipmentRepository repository) {
        this.repository = repository;
    }

    public Equipment add(Equipment equipment) {
        return this.repository.save(equipment);
    }

    public Equipment update(Equipment equipment) {
        return this.repository.save(equipment);
    }

    public Iterable<Equipment> list() {
        return this.repository.findAll();
    }

    public Optional<Equipment> findById(Long id) {
        return this.repository.findById(id);
    }


    public Optional<Equipment> delete(Long id) {
        Optional<Equipment> deleted = findById(id);
        this.repository.deleteById(id);
        return deleted;
    }
}
