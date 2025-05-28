package quipux.io.back.song.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "song")
public class SongEntity {

    @Id
    @JsonIgnore
    private String id;
    private String titulo;
    private String artista;
    private String album;
    private String anno;
    private String genero;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(final String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(final String album) {
        this.album = album;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(final String anno) {
        this.anno = anno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(final String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final SongEntity that = (SongEntity) o;
        return Objects.equals(id, that.id)
                &&  Objects.equals(titulo, that.titulo)
                && Objects.equals(artista, that.artista)
                && Objects.equals(album, that.album)
                && Objects.equals(anno, that.anno)
                && Objects.equals(genero, that.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, artista, album, anno, genero);
    }
}
