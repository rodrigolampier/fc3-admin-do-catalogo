package com.fullcycle.admin.catalogo.domain.category;

import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {

    private final String value;

    private CategoryID(final String value) {
        // Constraint: atributo value nao pode ser nulo
        Objects.requireNonNull(value);
        this.value = value;
    }

    // Gera um novo id para categoria
    public static CategoryID unique() {
        return CategoryID.from(UUID.randomUUID());
    }

    // Metodo helper: recebe o id em String e retorna em CategoryID
    public static CategoryID from(final String anId) {
        return new CategoryID(anId);
    }

    // Metodo helper: recebe o id em UUID e retorna em CategoryID
    public static CategoryID from(final UUID anId) {
        return new CategoryID(anId.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CategoryID that = (CategoryID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}