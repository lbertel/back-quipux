package quipux.io.back.lists_song.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import quipux.io.back.lists_song.domain.ListSong;
import quipux.io.back.lists_song.domain.ListSongRepository;

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

        list.add(new ListSong("fcecff92-a454-4ecb-be80-3b649fc6425b", "Salsa", "Salsa de la buena"));
        list.add(new ListSong("b44ace09-d94b-41c7-8584-7cc91935de72", "Rock", "Baladas en Ingles"));
        list.add(new ListSong("27b361ec-6e6f-48a6-80c5-781b3c5c2bca", "Classical", "Periodo Barroco"));

        return list;
    }
}
