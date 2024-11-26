package com.jbk.enums;

public enum ApplicationStatus {

    APPLIED("The application has been submitted"),
    APPROVED("The application has been approved"),
    REJECTED("The application has been rejected");

    private final String description;

    // Constructor
    ApplicationStatus(String description) {
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

