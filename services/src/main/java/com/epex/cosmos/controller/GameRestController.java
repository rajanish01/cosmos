package com.epex.cosmos.controller;

import com.epex.cosmos.domain.Game;
import com.epex.cosmos.enums.Side;
import com.epex.cosmos.services.GameControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameRestController {

    private final GameControlService gameControlService;

    @Autowired
    public GameRestController(final GameControlService gameControlService) {
        this.gameControlService = gameControlService;
    }

    @GetMapping
    @ResponseBody
    public Game startNewGame(@RequestParam("botAs") Side botAs) {
        return gameControlService.createNewGame(botAs);
    }

    @PostMapping("/next")
    @ResponseBody
    public Game getNextMove(@RequestBody Game currentState) {
        return gameControlService.generateNextMove(currentState);
    }

}
