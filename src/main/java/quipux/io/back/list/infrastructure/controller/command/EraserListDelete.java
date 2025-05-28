package quipux.io.back.list.infrastructure.controller.command;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quipux.io.back.list.application.ListService;
import quipux.io.back.list.infrastructure.persistence.ListSongEntity;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/list")
public class EraserListDelete {

    private final ListService service;

    public EraserListDelete(ListService service) {
        this.service = service;
    }

    @DeleteMapping("/{listName}")
    ResponseEntity<ListSongEntity> deleteByName(@PathVariable String listName) {
        Optional<Integer> listDeleted;
        try {
            listDeleted = service.delete(listName);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }

        if (listDeleted.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
