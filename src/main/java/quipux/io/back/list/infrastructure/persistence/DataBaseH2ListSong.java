package quipux.io.back.list.infrastructure.persistence;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface DataBaseH2ListSong extends JpaRepository<ListSongEntity, String> {
}
