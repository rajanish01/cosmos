package com.epex.cosmos.services.utils;

import com.epex.cerebro.inner.PermissiblePositionGenerator;
import com.epex.cosmos.domain.ChessPiece;
import com.epex.cosmos.domain.Game;
import com.epex.cosmos.domain.GameBoard;
import com.epex.cosmos.enums.PieceIndex;
import com.epex.cosmos.enums.PieceType;
import com.epex.cosmos.enums.Position;
import com.epex.cosmos.enums.Side;

import java.util.List;
import java.util.Random;

public class GameUtil {

    private static final Random random = new Random();

    private GameUtil() {
        throw new IllegalStateException("Utility Class !");
    }

    public static void playRandom(Game game) throws Exception {
        while (true) {
            var randomPieceTypeSelectIndex = random.nextInt(10);
            int randomPieceSelectIndex;
            int randomPositionSelectIndex;
            List<Position> validPositions;
            List<ChessPiece> pieces;
            if (randomPieceTypeSelectIndex == 1) {
                pieces = getSuitablePiece(game, PieceType.KING);
            } else if (randomPieceTypeSelectIndex == 2) {
                pieces = getSuitablePiece(game, PieceType.QUEEN);
            } else if (randomPieceTypeSelectIndex == 3) {
                pieces = getSuitablePiece(game, PieceType.BISHOP);
            } else if (randomPieceTypeSelectIndex == 4) {
                pieces = getSuitablePiece(game, PieceType.KNIGHT);
            } else if (randomPieceTypeSelectIndex == 5) {
                pieces = getSuitablePiece(game, PieceType.ROOK);
            } else {
                pieces = getSuitablePiece(game, PieceType.PAWN);
            }
            if (pieces.isEmpty()) continue;
            randomPieceSelectIndex = random.nextInt(pieces.size());
            ChessPiece selectedPiece = pieces.get(randomPieceSelectIndex);
            validPositions = PermissiblePositionGenerator.possiblePositionsForKing(game, selectedPiece);
            if (validPositions.isEmpty()) continue;
            randomPositionSelectIndex = random.nextInt(validPositions.size());
            movePiece(game.getGameBoard(), selectedPiece.getCurrentPosition(), validPositions.get(randomPositionSelectIndex));
            break;
        }
    }

    private static List<ChessPiece> getSuitablePiece(Game game, PieceType pieceType) {
        var botSide = game.getBotSide();
        String index = pieceType.getIndex();
        var pieceIndex = PieceIndex.valueOf(index.toUpperCase());
        return botSide == Side.WHITE ? GameBoard.getPiecesTypeOnBoard(game.getGameBoard(), pieceIndex) :
                GameBoard.getPiecesTypeOnBoard(game.getGameBoard(), PieceIndex.valueOf(index));
    }

    public static void movePiece(GameBoard gameBoard, Position oldPosition, Position newPosition) {
        gameBoard.getChessPieces()[newPosition.getColumn()][newPosition.getRow()] =
                gameBoard.getChessPieces()[oldPosition.getColumn()][oldPosition.getRow()];
        gameBoard.getChessPieces()[oldPosition.getColumn()][oldPosition.getRow()] = null;
    }


}
