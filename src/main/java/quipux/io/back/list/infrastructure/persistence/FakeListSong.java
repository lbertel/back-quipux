package quipux.io.back.list.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import quipux.io.back.list.domain.ListSong;
import quipux.io.back.list.domain.ListSongRepository;
import quipux.io.back.song.domain.Song;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeListSong implements ListSongRepository {

    @Override
    public List<ListSong> getAllListSong() {
        return createListOfSong();
    }

    private List<ListSong> createListOfSong() {
        List<ListSong> list = new ArrayList<>();
        List<Song> salsaList = new ArrayList<>();
        List<Song> rockList = new ArrayList<>();
        List<Song> classicalList = new ArrayList<>();

        list.add(new ListSong("Salsa", "Salsa de la buena", salsaList));
        list.add(new ListSong("Rock", "Baladas en Ingles", rockList));
        list.add(new ListSong("Classical", "Periodo Barroco", classicalList));

        return list;
    }
}
