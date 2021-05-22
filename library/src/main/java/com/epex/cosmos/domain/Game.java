package com.epex.cosmos.domain;

import com.epex.cosmos.enums.Side;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Game {

    private String gameId;

    @JsonIgnore
    private GameBoard gameBoard;

    private String fen;

    private Side botSide;

    private boolean playingRandom;

    public Game() {
    }

    private Game(String gameId, Side botAs, boolean playingRandom) {
        this.gameId = gameId;
        this.gameBoard = new GameBoard();
        this.botSide = botAs;
        this.playingRandom = playingRandom;
    }

    public static Game generateNewGame(String gameId, Side botAs, boolean playingRandom) {
        return new Game(gameId, botAs, playingRandom);
    }

}
