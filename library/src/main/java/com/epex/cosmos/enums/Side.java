package com.epex.cosmos.enums;

public enum Side {
    WHITE("w"), BLACK("b");

    private String code;

    Side(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Side getOtherSide() {
        return this.code.equals("w") ? Side.BLACK : Side.WHITE;
    }
}
