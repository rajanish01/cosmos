package com.epex.cosmos.services.utils;

import com.epex.cerebro.validator.MoveValidator;
import com.epex.cosmos.domain.ChessPiece;
import com.epex.cosmos.domain.FEN;
import com.epex.cosmos.domain.GameBoard;
import com.epex.cosmos.enums.Side;

public class GameUtil {
    private static final int PIECE_PLACEMENT_INDEX = 0;
    private static final int ACTIVE_COLOR_INDEX = 1;
    private static final int CASTLING_AVAILABILITY_INDEX = 2;
    private static final int EN_PASSANT_INDEX = 3;
    private static final int HALF_MOVE_CLOCK_INDEX = 4;
    private static final int FULL_MOVE_NUMBER_INDEX = 5;

    private static final int ROW_COUNT_ON_BOARD = 8;
    private static final int COLUMN_COUNT_ON_BOARD = 8;

    private static final String FEN_SEPARATOR = " ";
    private static final String PIECE_PLACEMENT_SEPARATOR = "/";
    private static final String NO_CASTLING_AVAILABILITY_MARK = "-";

    public static String fenGenerator(FEN fen) {
        return String.join(PIECE_PLACEMENT_SEPARATOR, fen.getPiecePlacements()) +
                FEN_SEPARATOR + fen.getActiveColor() +
                FEN_SEPARATOR + fen.getCastlingAvailability() +
                FEN_SEPARATOR + fen.getEnPassantTarget() +
                FEN_SEPARATOR + fen.getHalfMoveClock() +
                FEN_SEPARATOR + fen.getFullMoveNumber();
    }

    public static FEN fenParser(String fenSequence) {
        String[] fenSplitList = splitFenSequence(fenSequence);

        FEN fen = new FEN();
        fen.setPiecePlacements(getPiecePlacement(fenSplitList[PIECE_PLACEMENT_INDEX]));
        fen.setActiveColor(fenSplitList[ACTIVE_COLOR_INDEX]);
        fen.setCastlingAvailability(fenSplitList[CASTLING_AVAILABILITY_INDEX]);
        fen.setEnPassantTarget(fenSplitList[EN_PASSANT_INDEX]);
        fen.setHalfMoveClock(Integer.parseInt(fenSplitList[HALF_MOVE_CLOCK_INDEX]));
        fen.setFullMoveNumber(Integer.parseInt(fenSplitList[FULL_MOVE_NUMBER_INDEX]));
        return fen;
    }

    public static String[] generatePiecePlacementSequences(ChessPiece[][] chessPieces) {
        String[] piecePlacementSequenceList = new String[ROW_COUNT_ON_BOARD];

        for (int row = 0; row < ROW_COUNT_ON_BOARD; row++) {
            String piecePlacementSequence = "";
            int emptyPlaceCounter = 0;
            for (int column = 0; column < COLUMN_COUNT_ON_BOARD; column++) {
                if (chessPieces[column][row] == null) {
                    emptyPlaceCounter++;
                } else {
                    if (emptyPlaceCounter > 0) {
                        piecePlacementSequence = piecePlacementSequence.concat(String.valueOf(emptyPlaceCounter));
                        emptyPlaceCounter = 0;
                    }
                    piecePlacementSequence = piecePlacementSequence.concat(chessPieces[column][row].getPiece().getPieceIndex().name());
                }
            }
            if (emptyPlaceCounter > 0) {
                piecePlacementSequence = piecePlacementSequence.concat(String.valueOf(emptyPlaceCounter));
            }
            piecePlacementSequenceList[row] = piecePlacementSequence;
        }
        return piecePlacementSequenceList;
    }

    public static String getCastlingAvailabilitySequence(GameBoard gameBoard) {
        String castlingAvailabiltySequence = MoveValidator.isCastlingAvailableForSide(gameBoard, Side.WHITE) ? NO_CASTLING_AVAILABILITY_MARK : "Something";
        return castlingAvailabiltySequence;
    }

    private static String[] splitFenSequence(String fenSequence) {
        return fenSequence.split(FEN_SEPARATOR);
    }

    private static String[] getPiecePlacement(String piecePlacementSequence) {
        return piecePlacementSequence.split(PIECE_PLACEMENT_SEPARATOR);
    }
}
