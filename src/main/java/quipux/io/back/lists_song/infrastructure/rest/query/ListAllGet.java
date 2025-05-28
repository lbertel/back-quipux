package quipux.io.back.lists_song.infrastructure.rest.query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import quipux.io.back.lists_song.application.ListAllService;
import quipux.io.back.lists_song.domain.ListSong;

import java.util.List;

@RestController
public class ListAllGet {

    private final ListAllService service;

    public ListAllGet(final ListAllService service) {
        this.service = service;
    }

    @GetMapping("/lists")
    public ResponseEntity<List<ListSong>> listAll() {
        List<ListSong> response = service.ask();

        return ResponseEntity.ok(response);
    }
}
