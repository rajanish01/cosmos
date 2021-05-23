package com.epex.cosmos.services;

import com.epex.cosmos.domain.FEN;
import com.epex.cosmos.domain.Game;
import com.epex.cosmos.domain.GameBoard;
import com.epex.cosmos.enums.Side;
import com.epex.cosmos.repository.GameHistoryRepository;
import com.epex.cosmos.services.utils.FENUtil;
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

    public Game createNewGame(Game newGameConfig) throws Exception {
        String newGameId = generateNewGameId();
        var game = Game.generateNewGame(newGameId, newGameConfig.getBotSide(), newGameConfig.isPlayingRandom());
        var fen = FENUtil.generateFenFromGameBoard(game, Side.WHITE);
        game.setFen(FEN.fenGenerator(fen));
        if(newGameConfig.getBotSide() == Side.WHITE){
            generateNextMove(game);
        }
        return game;
    }

    public Game generateNextMove(Game game) throws Exception {
        game.setGameBoard(new GameBoard());
        var lastMoveFen = FEN.fenParser(game.getFen());
        FENUtil.setBoardBasedOnFen(game, lastMoveFen);
        if (game.isPlayingRandom()) {
            GameUtil.playRandom(game);
        } else {
            //TODO : IMPLEMENT ACTUAL LOGIC
        }
        game.setFen(FEN.fenGenerator(FENUtil.generateFenFromGameBoard(game, game.getBotSide().getOtherSide())));
        return game;
    }

    private String generateNewGameId() {
        return UUID.randomUUID().toString();
    }

}
