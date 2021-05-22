package com.epex.cosmos.services;

import com.epex.cosmos.domain.FEN;
import com.epex.cosmos.domain.Game;
import com.epex.cosmos.enums.Side;
import com.epex.cosmos.repository.GameHistoryRepository;
import com.epex.cosmos.services.utils.FENUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public Game createNewGame(Game newGameConfig) {
        String newGameId = generateNewGameId();
        Game game = Game.generateNewGame(newGameId, newGameConfig.getBotSide(), newGameConfig.isPlayingRandom());
        FEN fen = FENUtil.generateFenFromGameBoard(game, Side.WHITE);
        game.setFen(FEN.fenGenerator(fen));
        return game;
    }

    public Game generateNextMove(Game game) throws Exception {
        var lastMoveFen = FEN.fenParser(game.getFen());
        FENUtil.setBoardBasedOnFen(game, lastMoveFen);
        if (game.isPlayingRandom()) {

        } else {

        }
        //game.setFen(FENUtil.fenGenerator(l));
        return game;
    }

    private String generateNewGameId() {
        return UUID.randomUUID().toString();
    }

}
