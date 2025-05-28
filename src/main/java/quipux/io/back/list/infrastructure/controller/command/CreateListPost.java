package quipux.io.back.list.infrastructure.controller.command;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quipux.io.back.list.application.ListService;
import quipux.io.back.list.infrastructure.persistence.ListSongEntity;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/list")
public class CreateListPost {

    private final ListService service;

    public CreateListPost(ListService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<ListSongEntity> create(@RequestBody Dto dto) {
        Optional<ListSongEntity> newListSong;

        try {
            newListSong = service.create(dto.getNombre(), dto.getDescripcion());
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().build();
        }

        return newListSong.map(listSongEntity -> new ResponseEntity<>(listSongEntity, HttpStatus.CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    private static class Dto{
        private String nombre;
        private String descripcion;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(final String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(final String descripcion) {
            this.descripcion = descripcion;
        }
    }

}
