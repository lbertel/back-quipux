package quipux.io.back.list.domain;

import quipux.io.back.list.infrastructure.persistence.ListSongEntity;

import java.util.List;

public interface ListSongRepository {
    List<ListSongEntity> getAllListSong();
}
