package com.example.bank.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Role {
    ROLE_USER,
    ROLE_ADMIN;

    public String value() {
        return name();
    }

    public static Role fromValue(String v) {
        return valueOf(v);
    }
}


