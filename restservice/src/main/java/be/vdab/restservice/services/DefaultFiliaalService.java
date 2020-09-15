package be.vdab.restservice.services;

import be.vdab.restservice.domain.Filiaal;
import be.vdab.restservice.exceptions.FiliaalNietGevondenException;
import be.vdab.restservice.repositories.FiliaalRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DefaultFiliaalService implements FiliaalService {
    private final FiliaalRepository repository;

    public DefaultFiliaalService(FiliaalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Filiaal> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Filiaal> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Filiaal filiaal) {
        repository.save(filiaal);
    }

    @Override
    public void update(Filiaal filiaal) {
        repository.save(filiaal);
    }

    @Override
    public void delete(long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new FiliaalNietGevondenException();
        }
    }
}
