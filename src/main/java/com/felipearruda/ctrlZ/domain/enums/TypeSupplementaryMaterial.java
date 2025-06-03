package com.felipearruda.ctrlZ.domain.enums;

public enum TypeSupplementaryMaterial {
    PDF("PDF"),
    VIDEO("Video"),
    AUDIO("Audio"),
    EXTERNAL_LINK("External Link"),
    SLIDES("Slides"),
    IMAGE("Image"),
    EDITABLE_DOCUMENT("Editable Document"),
    SOURCE_CODE("Source Code");

    private final String label;

    TypeSupplementaryMaterial(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

