package quipux.io.back.list.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import quipux.io.back.list.domain.ListSongRepository;

import java.util.List;

@Repository
public class FakeListSong implements ListSongRepository {


    @Override
    public List<ListSongEntity> getAllListSong() {
        return List.of();
    }
}
