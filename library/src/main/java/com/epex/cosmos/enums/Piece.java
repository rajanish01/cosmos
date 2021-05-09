package com.epex.cosmos.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Piece {

    br1(PieceType.ROOK, Side.BLACK, PieceIndex.r), bn1(PieceType.KNIGHT, Side.BLACK, PieceIndex.n),
    bb1(PieceType.BISHOP, Side.BLACK, PieceIndex.b), bq(PieceType.QUEEN, Side.BLACK, PieceIndex.q),
    bk(PieceType.KING, Side.BLACK, PieceIndex.k), bb2(PieceType.BISHOP, Side.BLACK, PieceIndex.b),
    bn2(PieceType.KNIGHT, Side.BLACK, PieceIndex.n), br2(PieceType.ROOK, Side.BLACK, PieceIndex.r),

    bp1(PieceType.PAWN, Side.BLACK, PieceIndex.p), bp2(PieceType.PAWN, Side.BLACK, PieceIndex.p),
    bp3(PieceType.PAWN, Side.BLACK, PieceIndex.p), bp4(PieceType.PAWN, Side.BLACK, PieceIndex.p),
    bp5(PieceType.PAWN, Side.BLACK, PieceIndex.p), bp6(PieceType.PAWN, Side.BLACK, PieceIndex.p),
    bp7(PieceType.PAWN, Side.BLACK, PieceIndex.p), bp8(PieceType.PAWN, Side.BLACK, PieceIndex.p),

    wr1(PieceType.ROOK, Side.WHITE, PieceIndex.R), wn1(PieceType.KNIGHT, Side.WHITE, PieceIndex.N),
    wb1(PieceType.BISHOP, Side.WHITE, PieceIndex.B), wq(PieceType.QUEEN, Side.WHITE, PieceIndex.Q),
    wk(PieceType.KING, Side.WHITE, PieceIndex.K), wb2(PieceType.BISHOP, Side.WHITE, PieceIndex.B),
    wn2(PieceType.KNIGHT, Side.WHITE, PieceIndex.N), wr2(PieceType.ROOK, Side.WHITE, PieceIndex.R),

    wp1(PieceType.PAWN, Side.WHITE, PieceIndex.P), wp2(PieceType.PAWN, Side.WHITE, PieceIndex.P),
    wp3(PieceType.PAWN, Side.WHITE, PieceIndex.P), wp4(PieceType.PAWN, Side.WHITE, PieceIndex.P),
    wp5(PieceType.PAWN, Side.WHITE, PieceIndex.P), wp6(PieceType.PAWN, Side.WHITE, PieceIndex.P),
    wp7(PieceType.PAWN, Side.WHITE, PieceIndex.P), wp8(PieceType.PAWN, Side.WHITE, PieceIndex.P);

    private final PieceType pieceType;
    private final Side side;
    private final PieceIndex pieceIndex;

    Piece(PieceType type, Side side, PieceIndex pieceIndex) {
        this.pieceType = type;
        this.side = side;
        this.pieceIndex = pieceIndex;
    }

    public static List<Piece> findPiecesByTypeAndSide(PieceType pieceType, Side side) {
        return Arrays
                .stream(Piece.values())
                .filter(p -> p.side == side && p.pieceType == pieceType)
                .collect(Collectors.toList());
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
