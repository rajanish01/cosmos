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

    private Side activeSide;

    public Game() {
    }

    private Game(String gameId, Side botAs) {
        this.gameId = gameId;
        this.gameBoard = new GameBoard(botAs);
        this.activeSide = Side.WHITE;
    }

    public static Game generateNewGame(String gameId, Side botAs) {
        return new Game(gameId, botAs);
    }

}
