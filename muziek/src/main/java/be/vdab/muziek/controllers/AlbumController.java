package be.vdab.muziek.controllers;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.domain.AlbumNaamEnArtiest;
import be.vdab.muziek.domain.Track;
import be.vdab.muziek.exceptions.AlbumNietGevondenException;
import be.vdab.muziek.services.AlbumService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/albums")
@ExposesResourceFor(Album.class)
@CrossOrigin(exposedHeaders = "Location")
public class AlbumController {
    private final AlbumService service;
    private final EntityLinks entityLinks;

    public AlbumController(AlbumService service, EntityLinks entityLinks) {
        this.service = service;
        this.entityLinks = entityLinks;
    }
    @GetMapping("{id}")
    EntityModel<AlbumNaamEnArtiest> get(@PathVariable long id) {

        return service.findById(id).map(album ->
                EntityModel.of(new AlbumNaamEnArtiest(album),entityLinks.linkToItemResource(Album.class, album.getId()),
                        entityLinks.linkForItemResource(Album.class, album.getId())
                                .slash("tracks")
                                .withRel("tracks")))
                .orElseThrow(AlbumNietGevondenException::new);
    }
    @GetMapping("{id}/tracks")
    List<Track> getTrack(@PathVariable long id){
        return new ArrayList<>(service.findById(id).get().getTracks());
    }

    @ExceptionHandler(AlbumNietGevondenException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void albumNietGevonden() {
    }
}
