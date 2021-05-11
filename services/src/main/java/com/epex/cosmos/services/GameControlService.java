package com.epex.cosmos.services;

import com.epex.cerebro.inner.PermissiblePositionGenerator;
import com.epex.cosmos.domain.FEN;
import com.epex.cosmos.domain.Game;
import com.epex.cosmos.enums.Position;
import com.epex.cosmos.enums.Side;
import com.epex.cosmos.repository.GameHistoryRepository;
import com.epex.cosmos.services.utils.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameControlService {

    private final GameHistoryRepository gameHistoryRepository;

    @Autowired
    public GameControlService(final GameHistoryRepository gameHistoryRepository) {
        this.gameHistoryRepository = gameHistoryRepository;
    }

    public Game createNewGame(Side botAs) {
        String newGameId = generateNewGameId();
        Game game = Game.generateNewGame(newGameId, botAs);
        generateNextMove(game);
        FEN fen = getFenFromGameBoard(game);
        game.setFen(GameUtil.fenGenerator(fen));
        return game;
    }

    public void generateNextMove(Game game) {
        try {
            List<Position> possibleMoves = PermissiblePositionGenerator
                    .possiblePositionsForPawn(game.getGameBoard(), game.getGameBoard().getChessPieces()[2][1]);
            GameUtil.movePiece(game.getGameBoard(), Position.fromValue(2, 1), possibleMoves.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String generateNewGameId() {
        return UUID.randomUUID().toString();
    }

    private FEN getFenFromGameBoard(Game game) {
        FEN fen = new FEN();
        fen.setPiecePlacements(GameUtil.generatePiecePlacementSequences(game.getGameBoard().getChessPieces()));
        fen.setActiveColor(game.getActiveSide().getCode());
        fen.setCastlingAvailability(GameUtil.generateCastlingAvailabilitySequence(game.getGameBoard()));
        fen.setEnPassantTarget(GameUtil.generateEnPassantTargetSequence(game.getGameBoard(), game.getActiveSide()));
        fen.setHalfMoveClock(GameUtil.generateHalfMoveClock());
        fen.setFullMoveNumber(GameUtil.generateFullMoveNumber());
        return fen;
    }

}
