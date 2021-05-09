package com.epex.cosmos.services;

import com.epex.cosmos.domain.FEN;
import com.epex.cosmos.domain.Game;
import com.epex.cosmos.enums.Side;
import com.epex.cosmos.repository.GameHistoryRepository;
import com.epex.cosmos.services.utils.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        FEN fen = getFenFromGameBoard(game);
        game.setFen(GameUtil.fenGenerator(fen));
        return game;
    }

    public Game generateNextMove(Game humanMove) {
        // Game botMove = new Game();

        return null;
    }

    private String generateNewGameId() {
        return UUID.randomUUID().toString();
    }

    private FEN getFenFromGameBoard(Game game) {
        FEN fen = new FEN();
        fen.setPiecePlacements(GameUtil.generatePiecePlacementSequences(game.getGameBoard().getChessPieces()));
        fen.setActiveColor(game.getActiveSide().getCode());
        fen.setCastlingAvailability(null);
        fen.setEnPassantTarget(null);
        fen.setHalfMoveClock(0);
        fen.setFullMoveNumber(0);
        return fen;
    }

}
