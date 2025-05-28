package quipux.io.back.lists_song.application;

import org.springframework.stereotype.Service;
import quipux.io.back.lists_song.domain.ListSong;
import quipux.io.back.lists_song.domain.ListSongRepository;

import java.util.List;

@Service
public class ListAllService {

    private final ListSongRepository repository;

    public ListAllService(final ListSongRepository repository) {
        this.repository = repository;
    }

    public List<ListSong> ask() {
        return repository.getAllListSong();
    }

}
