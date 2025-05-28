package quipux.io.back.list.infrastructure.controller.query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quipux.io.back.list.application.ListAllService;
import quipux.io.back.list.infrastructure.persistence.ListSongEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/list")
public class ListAllGet {

    private final ListAllService service;

    public ListAllGet(final ListAllService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<ListSongEntity>> listAll() {
        List<ListSongEntity> response = service.ask();

        return ResponseEntity.ok(response);
    }
}
