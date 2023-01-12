package dev.suresh.data;

import java.util.Objects;

public record JavaRec(String name, String version) {
    public JavaRec {
        Objects.requireNonNull(name, "Name is required");
        Objects.requireNonNull(version, "Version is required");
    }

    public JavaRec() {
        this("Java", System.getProperty("java.version"));
    }
}
