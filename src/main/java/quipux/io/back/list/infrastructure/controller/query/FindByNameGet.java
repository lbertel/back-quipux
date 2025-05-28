package quipux.io.back.list.infrastructure.controller.query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quipux.io.back.list.domain.ListNameVO;
import quipux.io.back.list.infrastructure.persistence.ListSongEntity;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/list")
public class FindByNameGet {


    @GetMapping("/{listName}")
    public ResponseEntity<ListSongEntity> findBy(@RequestBody String listName) {
        ListNameVO vo = null;
        try {
            vo = new ListNameVO(listName);
        } catch (IllegalArgumentException error) {
            return ResponseEntity.badRequest().build();
        }

        Optional<ListSongEntity> response = null;

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
