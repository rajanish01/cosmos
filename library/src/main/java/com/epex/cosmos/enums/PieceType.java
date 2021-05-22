package com.epex.cosmos.enums;

import java.util.Arrays;

public enum PieceType {

    ROOK(5, "r"), KNIGHT(3, "n"), BISHOP(3, "b"),
    KING(0, "k"), QUEEN(9, "q"), PAWN(1, "p");

    private final int weight;
    private final String index;

    PieceType(int weight, String index) {
        this.weight = weight;
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public String getIndex() {
        return index;
    }

    public PieceType findByIndex(String index) throws Exception {
        return Arrays
                .stream(PieceType.values())
                .filter(p -> p.getIndex().equals(index))
                .findFirst()
                .orElseThrow(() -> new Exception("Piece Type For Index Not Found !"));
    }
}
