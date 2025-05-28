package quipux.io.back.list.domain;

public record ListNameVO(String name) {

    public ListNameVO(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("The list name is null");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("The list name is empty");
        }
        this.name = name;
    }
}
