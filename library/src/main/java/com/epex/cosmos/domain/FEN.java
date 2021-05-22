package com.epex.cosmos.domain;

import lombok.Data;

@Data
public class FEN {

    private static final int PIECE_PLACEMENT_INDEX = 0;
    private static final int ACTIVE_COLOR_INDEX = 1;
    private static final int CASTLING_AVAILABILITY_INDEX = 2;
    private static final int EN_PASSANT_INDEX = 3;
    private static final int HALF_MOVE_CLOCK_INDEX = 4;
    private static final int FULL_MOVE_NUMBER_INDEX = 5;

    private static final String SEPARATOR = " ";
    private static final String PIECE_PLACEMENT_SEPARATOR = "/";

    private String[] piecePlacements;

    private String activeColor;

    private String castlingAvailability;

    private String enPassantTarget;

    private int halfMoveClock;

    private int fullMoveNumber;

    /**
     * Converts FEN Object To String Sequence
     *
     * @param fen Object
     * @return FEN Sequence
     */
    public static String fenGenerator(FEN fen) {
        return String.join(PIECE_PLACEMENT_SEPARATOR, fen.getPiecePlacements()) +
                SEPARATOR + fen.getActiveColor() +
                SEPARATOR + fen.getCastlingAvailability() +
                SEPARATOR + fen.getEnPassantTarget() +
                SEPARATOR + fen.getHalfMoveClock() +
                SEPARATOR + fen.getFullMoveNumber();
    }

    /**
     * Converts FEN String Sequence To FEN Object
     *
     * @param fenSequence string
     * @return FEN Object
     */
    public static FEN fenParser(String fenSequence) {
        String[] fenSplitList = splitFenSequence(fenSequence);
        var fen = new FEN();
        fen.setPiecePlacements(getPiecePlacement(fenSplitList[PIECE_PLACEMENT_INDEX]));
        fen.setActiveColor(fenSplitList[ACTIVE_COLOR_INDEX]);
        fen.setCastlingAvailability(fenSplitList[CASTLING_AVAILABILITY_INDEX]);
        fen.setEnPassantTarget(fenSplitList[EN_PASSANT_INDEX]);
        fen.setHalfMoveClock(Integer.parseInt(fenSplitList[HALF_MOVE_CLOCK_INDEX]));
        fen.setFullMoveNumber(Integer.parseInt(fenSplitList[FULL_MOVE_NUMBER_INDEX]));
        return fen;
    }



    private static String[] splitFenSequence(String fenSequence) {
        return fenSequence.split(SEPARATOR);
    }

    private static String[] getPiecePlacement(String piecePlacementSequence) {
        return piecePlacementSequence.split(PIECE_PLACEMENT_SEPARATOR);
    }
}
