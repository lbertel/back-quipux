package quipux.io.back.list.domain;

public record NombreVO(String name) {

    public NombreVO {
        if (name == null) {
            throw new IllegalArgumentException("The list name is null");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("The list name is empty");
        }
    }
}
