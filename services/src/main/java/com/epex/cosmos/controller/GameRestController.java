package com.epex.cosmos.controller;

import com.epex.cosmos.domain.Game;
import com.epex.cosmos.services.GameControlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@SuppressWarnings("unused")
public class GameRestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final GameControlService gameControlService;

    @Autowired
    public GameRestController(final GameControlService gameControlService) {
        this.gameControlService = gameControlService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> startNewGame(@RequestBody final Game newGameConfig) {
        try {
            return ResponseEntity.accepted().body(gameControlService.createNewGame(newGameConfig));
        } catch (Exception e) {
            logger.error("Error While Generating New Game : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/next")
    @ResponseBody
    public ResponseEntity<?> getNextMove(@RequestBody Game currentState) {
        try {
            return ResponseEntity.accepted().body(gameControlService.generateNextMove(currentState));
        } catch (Exception e) {
            logger.error("Error While Generating Next Move : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
