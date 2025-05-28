package quipux.io.back.lists_song.infrastructure.rest.query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import quipux.io.back.lists_song.domain.ListSong;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListAllGet {

    @GetMapping("/lists")
    public ResponseEntity<List<ListSong>> listAll() {
        return ResponseEntity.ok(new ArrayList<ListSong>());
    }
}
