package com.epex.cosmos.repository;

import com.epex.cosmos.enums.GameStatus;
import com.epex.cosmos.enums.Side;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "game_history")
@Data
public class GameHistory {

    @Id
    private String id;

    private Side bot_as;

    private Side human_as;

    private String last_fen;

    private GameStatus game_status;

}
