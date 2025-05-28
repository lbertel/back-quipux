package quipux.io.back.list.domain;

import quipux.io.back.song.domain.Song;

import java.util.List;

public record ListSong(String nombre, String descripcion, List<Song> songs) {
}
