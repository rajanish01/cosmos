package com.epex.cosmos.enums;

public enum PieceType {

    ROOK(5), KNIGHT(3), BISHOP(3), KING(100), QUEEN(9), PAWN(1);

    private final int weight;

    PieceType(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
