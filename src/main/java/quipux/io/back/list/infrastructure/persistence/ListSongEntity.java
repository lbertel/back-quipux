package quipux.io.back.list.infrastructure.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import quipux.io.back.song.infrastructure.SongEntity;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "list")
public class ListSongEntity {

    @Id
    @JsonIgnore
    private String id;
    private String nombre;
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "song_list_id")
    private List<SongEntity> canciones;

    public ListSongEntity() {
    }

    public ListSongEntity(final String id, final String nombre, final String descripcion, final List<SongEntity> canciones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.canciones = canciones;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public List<SongEntity> getCanciones() {
        return canciones;
    }

    public void setCanciones(final List<SongEntity> canciones) {
        this.canciones = canciones;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final ListSongEntity that = (ListSongEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(nombre, that.nombre)
                && Objects.equals(descripcion, that.descripcion)
                && Objects.equals(canciones, that.canciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, canciones);
    }
}
