package quipux.io.back.lists.infrastructure.rest.query;

import quipux.io.back.list.infrastructure.persistence.ListSongEntity;
import quipux.io.back.song.infrastructure.SongEntity;

import java.util.ArrayList;
import java.util.List;

public final class ListSongMother {

    private ListSongMother() {

    }

    public static List<ListSongEntity> createListOfSong() {
        List<ListSongEntity> list = new ArrayList<>();

        List<SongEntity> salsaList = new ArrayList<>();
        List<SongEntity> rockList = new ArrayList<>();
        List<SongEntity> classicalList = new ArrayList<>();

        list.add(new ListSongEntity("5645825d-71e1-48e9-a2a4-2b1f09c9fb99" ,"Salsa", "Salsa de la buena", salsaList));
        list.add(new ListSongEntity("a2d192d5-20f5-4fed-a964-475c8292be79", "Rock", "Baladas en Ingles", rockList));
        list.add(new ListSongEntity("2ca3a205-0180-4fd2-a60a-71ca37c1c721", "Classical", "Periodo Barroco", classicalList));

        return list;
    }
}
