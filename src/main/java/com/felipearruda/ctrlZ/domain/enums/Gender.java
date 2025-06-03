package com.felipearruda.ctrlZ.domain.enums;

import lombok.Getter;

@Getter
public enum Gender {

    FEMALE("Female"),
    MALE("Male");

    private String desc;

    Gender(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return getDesc();
    }

}
