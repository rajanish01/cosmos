package com.epex.cosmos.services.utils;

import com.epex.cerebro.inner.MoveGenerator;
import com.epex.cerebro.validator.MoveValidator;
import com.epex.cosmos.domain.ChessPiece;
import com.epex.cosmos.domain.FEN;
import com.epex.cosmos.domain.Game;
import com.epex.cosmos.domain.GameBoard;
import com.epex.cosmos.enums.*;

public class FENUtil {

    private static final int ROW_COUNT_ON_BOARD = 8;
    private static final int COLUMN_COUNT_ON_BOARD = 8;

    private FENUtil() {
        throw new IllegalStateException("Utility Class !");
    }

    /**
     * Generate FEN Object From Game
     *
     * @param game        game object
     * @param activeColor
     * @return FEN Object
     */
    public static FEN generateFenFromGameBoard(Game game, Side activeColor) {
        var fen = new FEN();
        fen.setPiecePlacements(FENUtil.generatePiecePlacementSequences(game.getGameBoard().getChessPieces()));
        fen.setActiveColor(activeColor.getCode());
        fen.setCastlingAvailability(FENUtil.generateCastlingAvailabilitySequence(game));
        fen.setEnPassantTarget(FENUtil.generateEnPassantTargetSequence(game.getGameBoard(), game.getBotSide()));
        fen.setHalfMoveClock(FENUtil.generateHalfMoveClock());
        fen.setFullMoveNumber(FENUtil.generateFullMoveNumber());
        return fen;
    }

    /**
     * Generate Game Board From FEN Object
     *
     * @param game Game Object
     * @param fen  Fen Object
     * @throws Exception
     */
    public static void setBoardBasedOnFen(Game game, FEN fen) throws Exception {
        var piecePlacements = fen.getPiecePlacements();
        var board = game.getGameBoard();
        for (var rowSequence = 0; rowSequence < piecePlacements.length; rowSequence++) {
            var placementsInRow = piecePlacements[rowSequence].toCharArray();
            var columnItr = 0;
            for (var columnIndex = 0; columnIndex < placementsInRow.length; columnIndex++) {
                if (Character.isDigit(placementsInRow[columnIndex])) {
                    var emptyPlaces = Integer.parseInt(String.valueOf(placementsInRow[columnIndex]));
                    for (var itr = 0; itr < emptyPlaces; itr++) {
                        board.getChessPieces()[columnItr++][rowSequence] = null;
                    }
                } else {
                    board.getChessPieces()[columnItr++][rowSequence] = new ChessPiece(
                            Piece.findByPieceIndex(
                                    PieceIndex.valueOf(
                                            String.valueOf(
                                                    placementsInRow[columnIndex]))),
                            Position.fromValue(columnIndex, rowSequence));
                }
            }
        }
    }

    public static String[] generatePiecePlacementSequences(ChessPiece[][] chessPieces) {
        var piecePlacementSequenceList = new String[ROW_COUNT_ON_BOARD];

        for (var row = 0; row < ROW_COUNT_ON_BOARD; row++) {
            var piecePlacementSequence = "";
            var emptyPlaceCounter = 0;
            for (var column = 0; column < COLUMN_COUNT_ON_BOARD; column++) {
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

    public static String generateCastlingAvailabilitySequence(Game game) {
        var castlingAvailabilitySequence = "";
        if (MoveValidator.isCastlingValidForKingSide(game, Side.WHITE)) {
            castlingAvailabilitySequence = castlingAvailabilitySequence + CastlingType.K.getSymbol();
        }
        if (MoveValidator.isCastlingValidForQueenSide(game, Side.WHITE)) {
            castlingAvailabilitySequence = castlingAvailabilitySequence + CastlingType.Q.getSymbol();
        }
        if (MoveValidator.isCastlingValidForKingSide(game, Side.BLACK)) {
            castlingAvailabilitySequence = castlingAvailabilitySequence + CastlingType.k.getSymbol();
        }
        if (MoveValidator.isCastlingValidForQueenSide(game, Side.WHITE)) {
            castlingAvailabilitySequence = castlingAvailabilitySequence + CastlingType.q.getSymbol();
        }
        return castlingAvailabilitySequence.equals("") ? CastlingType.NA.getSymbol() : castlingAvailabilitySequence;
    }

    public static String generateEnPassantTargetSequence(GameBoard gameBoard, Side side) {
        return MoveGenerator.enPassTarget(gameBoard, side);
    }

    public static int generateHalfMoveClock() {
        return 1;
    }

    public static int generateFullMoveNumber() {
        return 1;
    }

}
