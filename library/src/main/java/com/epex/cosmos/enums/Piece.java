package com.epex.cosmos.enums;

import java.util.Arrays;

public enum Piece {

    br(PieceType.ROOK, Side.BLACK, PieceIndex.r), bn(PieceType.KNIGHT, Side.BLACK, PieceIndex.n),
    bb(PieceType.BISHOP, Side.BLACK, PieceIndex.b), bq(PieceType.QUEEN, Side.BLACK, PieceIndex.q),
    bk(PieceType.KING, Side.BLACK, PieceIndex.k), bp(PieceType.PAWN, Side.BLACK, PieceIndex.p),

    wr(PieceType.ROOK, Side.WHITE, PieceIndex.R), wn(PieceType.KNIGHT, Side.WHITE, PieceIndex.N),
    wb(PieceType.BISHOP, Side.WHITE, PieceIndex.B), wq(PieceType.QUEEN, Side.WHITE, PieceIndex.Q),
    wk(PieceType.KING, Side.WHITE, PieceIndex.K), wp(PieceType.PAWN, Side.WHITE, PieceIndex.P);

    private final PieceType pieceType;
    private final Side side;
    private final PieceIndex pieceIndex;

    Piece(PieceType type, Side side, PieceIndex pieceIndex) {
        this.pieceType = type;
        this.side = side;
        this.pieceIndex = pieceIndex;
    }

    public static Piece findPiecesByTypeAndSide(PieceType pieceType, Side side) throws Exception {
        return Arrays
                .stream(Piece.values())
                .filter(p -> p.side == side && p.pieceType == pieceType)
                .findFirst()
                .orElseThrow(() -> new Exception("No Piece Found !"));
    }

    public static Piece findByPieceIndex(PieceIndex index) throws Exception {
        return Arrays
                .stream(Piece.values())
                .filter(p -> p.pieceIndex == index)
                .findFirst()
                .orElseThrow(() -> new Exception("No Piece Found !"));
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Side getSide() {
        return side;
    }

    public PieceIndex getPieceIndex() {
        return pieceIndex;
    }
}
