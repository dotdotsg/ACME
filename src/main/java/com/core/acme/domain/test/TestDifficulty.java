package com.core.acme.domain.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public enum TestDifficulty{
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    @Valid
    @Pattern(regexp = "EASY|MEDIUM|HARD", message = "The Test Difficulty can be easy, medium or hard")
    String value;

    TestDifficulty(String value) {
        this.value = value;
    }

    @JsonCreator
    public static TestDifficulty fromValue(String text) {
        for (TestDifficulty b : TestDifficulty.values()) {
            if (String.valueOf(b.value).equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    @Override
    @JsonValue
    public String toString() {
        return (String.valueOf(value).substring(0, 1).toUpperCase()
                + String.valueOf(value).substring(1));
    }
}