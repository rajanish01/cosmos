package com.epex.cosmos.domain;

import com.epex.cosmos.enums.Piece;
import com.epex.cosmos.enums.Position;
import com.epex.cosmos.enums.Side;
import lombok.Data;

@Data
public class ChessPiece {

    private Piece piece;

    private Position currentPosition;

    private boolean onBoard;

    public ChessPiece(Piece piece, Position position) {
        this.piece = piece;
        this.currentPosition = position;
        this.onBoard = true;
    }
}
