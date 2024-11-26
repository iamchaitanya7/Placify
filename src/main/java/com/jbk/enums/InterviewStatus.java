package com.jbk.enums;

public enum InterviewStatus {
    SCHEDULED("The interview has been scheduled"),
    COMPLETED("The interview has been completed"),
    CANCELLED("The interview has been cancelled");

    private final String description;

    // Constructor
    InterviewStatus(String description) {
        this.description = description;
    }

    // Getter for description
    public String getValue () {
        return description;
    }

    // Override toString() for better readability
    @Override
    public String toString() {
        return String.format("%s - %s", this.name(), this.description);
    }
}
