package com.felipearruda.ctrlZ.domain.enums;

import lombok.Getter;

@Getter
public enum Category {

    AI(" Artificial Intelligence"),
    BACKEND("Backend"),
    CLOUD("Cloud"),
    CYBERSECURITY("Cybersecurity"),
    DATABASE("Database"),
    DEVOPS("DevOps"),
    FRONTEND("FrontEnd"),
    HARDWARE("Hardware"),
    MOBILE("Mobile"),
    NETWORKING("Networking"),
    PROJECT_MANAGEMENT("Project Management"),
    QA_TESTING("QA Testing"),
    UX_DESIGN("UX Design");

    private String desc;

    Category(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return getDesc();
    }

}
