package quipux.io.back.list.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quipux.io.back.list.domain.ListSongsVO;
import quipux.io.back.list.infrastructure.persistence.DataBaseH2ListSong;
import quipux.io.back.list.infrastructure.persistence.ListSongEntity;

import java.util.List;
import java.util.Optional;

@Service
public class ListService {

    private final DataBaseH2ListSong repository;

    public ListService(final DataBaseH2ListSong repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ListSongEntity> ask() {
        return repository.findAll();
    }

    public Optional<ListSongEntity> findBy(final String name) {
        return repository.findByNombre(name);
    }

    public Optional<ListSongEntity> create(final String nombre, final String descripcion) {
        ListSongsVO vo = new ListSongsVO(nombre, descripcion);
        final ListSongEntity newListSongEntity = new ListSongEntity(vo.getId(),
                vo.getNombre(), vo.getDescripcion(), vo.getCanciones());
        return Optional.of(repository.save(newListSongEntity));
    }
}