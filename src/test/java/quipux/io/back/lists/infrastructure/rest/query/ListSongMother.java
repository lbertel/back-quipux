package quipux.io.back.lists.infrastructure.rest.query;

import quipux.io.back.list.domain.ListSong;
import quipux.io.back.song.domain.Song;

import java.util.ArrayList;
import java.util.List;

public final class ListSongMother {

    private ListSongMother() {

    }

    public static List<ListSong> createListOfSong() {
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
