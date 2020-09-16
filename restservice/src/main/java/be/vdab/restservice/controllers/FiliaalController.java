package be.vdab.restservice.controllers;

import be.vdab.restservice.domain.Filiaal;
import be.vdab.restservice.domain.FiliaalIdNaam;
import be.vdab.restservice.exceptions.FiliaalNietGevondenException;
import be.vdab.restservice.services.FiliaalService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filialen")
@ExposesResourceFor(Filiaal.class)
public class FiliaalController {
    private final FiliaalService service;
    private final EntityLinks entityLinks;

    public FiliaalController(FiliaalService service, EntityLinks entityLinks) {
        this.service = service;
        this.entityLinks = entityLinks;
    }

    /*@GetMapping("{id}")
    Filiaal get(@PathVariable long id) {
        return service.findById(id)
                .orElseThrow(FiliaalNietGevondenException::new);
    }*/
    @GetMapping("{id}")
    @Operation(summary = "Een filiaal zoeken op id")
    EntityModel<Filiaal> get(@PathVariable long id) {
        return service.findById(id).map(filiaal ->
                EntityModel.of(filiaal, entityLinks.linkToItemResource(Filiaal.class, filiaal.getId()),
                        entityLinks.linkForItemResource(Filiaal.class, filiaal.getId())
                                .slash("werknemers")
                                .withRel("werknemers")))
                .orElseThrow(FiliaalNietGevondenException::new);
    }

    @ExceptionHandler(FiliaalNietGevondenException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void filiaalNietGevonden() {
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Een filiaal verwijderen")
    void delete(@PathVariable long id) {
        service.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    HttpHeaders create(@RequestBody @Valid Filiaal filiaal) {
        service.create(filiaal);
        var link = entityLinks.linkToItemResource(Filiaal.class, filiaal.getId());
        var headers = new HttpHeaders();
        headers.setLocation(link.toUri());
        return headers;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String, String> verkeerdeData(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

    @PutMapping("{id}")
    @Operation(summary = "Een filiaal wijzigen")
    void put(@RequestBody @Valid Filiaal filiaal) {
        service.update(filiaal);
    }

    @GetMapping
    CollectionModel<EntityModel<FiliaalIdNaam>> findAll() {
        return CollectionModel.of(service.findAll().stream()
                .map(filiaal -> EntityModel.of(new FiliaalIdNaam(filiaal),
                        entityLinks.linkToItemResource(Filiaal.class, filiaal.getId())))
                .collect(Collectors.toList()),
                entityLinks.linkToCollectionResource(Filiaal.class));
    }
}
