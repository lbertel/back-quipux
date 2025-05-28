package quipux.io.back.list.domain;

import quipux.io.back.song.infrastructure.SongEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class ListSongsVO {
    private final String id;
    private final NombreVO nombreVO;
    private final String descripcion;
    private final List<SongEntity> canciones;

    public ListSongsVO(final String nombre, final String descripcion) {
        this.id = UUID.randomUUID().toString();
        nombreVO = new NombreVO(nombre);
        this.descripcion = descripcion;
        this.canciones = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombreVO.name();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<SongEntity> getCanciones() {
        return canciones;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final ListSongsVO listSongsVO = (ListSongsVO) o;
        return Objects.equals(id, listSongsVO.id)
                && Objects.equals(nombreVO, listSongsVO.nombreVO)
                && Objects.equals(descripcion, listSongsVO.descripcion)
                && Objects.equals(canciones, listSongsVO.canciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreVO, descripcion, canciones);
    }
}
