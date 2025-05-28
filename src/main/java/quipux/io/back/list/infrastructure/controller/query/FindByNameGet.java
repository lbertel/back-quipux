package quipux.io.back.list.infrastructure.controller.query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quipux.io.back.list.application.ListService;
import quipux.io.back.list.domain.NombreVO;
import quipux.io.back.list.infrastructure.persistence.ListSongEntity;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/list")
public class FindByNameGet {

    private final ListService service;

    public FindByNameGet(final ListService service) {
        this.service = service;
    }

    @GetMapping("/{listName}")
    public ResponseEntity<ListSongEntity> findBy(@PathVariable String listName) {
        NombreVO vo = null;
        try {
            vo = new NombreVO(listName);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().build();
        }

        Optional<ListSongEntity> response = service.findBy(vo.name());

        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
