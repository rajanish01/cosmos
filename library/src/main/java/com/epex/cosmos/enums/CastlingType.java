package com.epex.cosmos.enums;

public enum CastlingType {
    K("K"), Q("Q"), k("k"), q("q"), NA("-");

    private final String symbol;

    CastlingType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
