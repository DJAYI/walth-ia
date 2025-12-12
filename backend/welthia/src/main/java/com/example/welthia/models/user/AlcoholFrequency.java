package com.example.welthia.models.user;

public enum AlcoholFrequency {
    NUNCA(1, "nunca lo he hecho"),
    RARA_VEZ(2, "lo he hecho una o dos veces"),
    OCASIONALMENTE(3, "ocasionalmente"),
    FRECUENTEMENTE(4, "frecuentemente"),
    MUY_FRECUENTEMENTE(5, "muy frecuentemente");

    private final int value;
    private final String description;

    AlcoholFrequency(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}