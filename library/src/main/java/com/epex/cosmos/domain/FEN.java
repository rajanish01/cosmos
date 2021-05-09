package com.epex.cosmos.domain;

import lombok.Data;

@Data
public class FEN {

    private String[] piecePlacements;

    private String activeColor;

    private String castlingAvailability;

    private String enPassantTarget;

    private int halfMoveClock;

    private int fullMoveNumber;

}
