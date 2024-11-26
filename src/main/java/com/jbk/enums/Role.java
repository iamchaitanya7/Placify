package com.jbk.enums;

public enum Role {
    ADMIN("ADMIN"),
    COLLEGE("COLLEGE"),
    COMPANY("COMPANY");

    private final String description;

    // Constructor
    Role(String description) {
        this.description = description;
    }

    // Getter for description
    public String getValue() {
        return description;
    }

    // Override toString() for better readability
    @Override
    public String toString() {
        return String.format("%s - %s", this.name(), this.description);
    }
}
