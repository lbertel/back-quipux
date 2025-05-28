package quipux.io.back.list.application;

import org.springframework.stereotype.Service;
import quipux.io.back.list.infrastructure.persistence.DataBaseH2ListSong;
import quipux.io.back.list.infrastructure.persistence.ListSongEntity;

import java.util.List;

@Service
public class ListService {

    private final DataBaseH2ListSong repository;

    public ListService(final DataBaseH2ListSong repository) {
        this.repository = repository;
    }

    public List<ListSongEntity> ask() {
        return repository.findAll();
    }

}
