package com.epex.cosmos.domain;

import com.epex.cosmos.enums.Piece;
import com.epex.cosmos.enums.Position;
import lombok.Data;

@Data
public class GameBoard {

    private ChessPiece[][] chessPieces = new ChessPiece[8][8];

    public GameBoard() {
        //SIDE -> BLACK
        chessPieces[0][0] = new ChessPiece(Piece.br, Position.A8);     //ROOK
        chessPieces[1][0] = new ChessPiece(Piece.bn, Position.B8);     //KNIGHT
        chessPieces[2][0] = new ChessPiece(Piece.bb, Position.C8);     //BISHOP
        chessPieces[3][0] = new ChessPiece(Piece.bq, Position.D8);     //QUEEN
        chessPieces[4][0] = new ChessPiece(Piece.bk, Position.E8);     //KING
        chessPieces[5][0] = new ChessPiece(Piece.bb, Position.F8);     //BISHOP
        chessPieces[6][0] = new ChessPiece(Piece.bn, Position.G8);     //KNIGHT
        chessPieces[7][0] = new ChessPiece(Piece.br, Position.H8);     //ROOK

        chessPieces[0][1] = new ChessPiece(Piece.bp, Position.A7);     //PAWN
        chessPieces[1][1] = new ChessPiece(Piece.bb, Position.B7);     //PAWN
        chessPieces[2][1] = new ChessPiece(Piece.bp, Position.C7);     //PAWN
        chessPieces[3][1] = new ChessPiece(Piece.bp, Position.D7);     //PAWN
        chessPieces[4][1] = new ChessPiece(Piece.bp, Position.E7);     //PAWN
        chessPieces[5][1] = new ChessPiece(Piece.bp, Position.F7);     //PAWN
        chessPieces[6][1] = new ChessPiece(Piece.bp, Position.G7);     //PAWN
        chessPieces[7][1] = new ChessPiece(Piece.bp, Position.H7);     //PAWN


        //SIDE -> WHITE
        chessPieces[0][6] = new ChessPiece(Piece.wp, Position.A2);     //PAWN
        chessPieces[1][6] = new ChessPiece(Piece.wp, Position.B2);     //PAWN
        chessPieces[2][6] = new ChessPiece(Piece.wp, Position.C2);     //PAWN
        chessPieces[3][6] = new ChessPiece(Piece.wp, Position.D2);     //PAWN
        chessPieces[4][6] = new ChessPiece(Piece.wp, Position.E2);     //PAWN
        chessPieces[5][6] = new ChessPiece(Piece.wp, Position.F2);     //PAWN
        chessPieces[6][6] = new ChessPiece(Piece.wp, Position.G2);     //PAWN
        chessPieces[7][6] = new ChessPiece(Piece.wp, Position.H2);     //PAWN

        chessPieces[0][7] = new ChessPiece(Piece.wr, Position.A1);     //ROOK
        chessPieces[1][7] = new ChessPiece(Piece.wn, Position.B1);     //KNIGHT
        chessPieces[2][7] = new ChessPiece(Piece.wb, Position.C1);     //BISHOP
        chessPieces[3][7] = new ChessPiece(Piece.wq, Position.D1);     //QUEEN
        chessPieces[4][7] = new ChessPiece(Piece.wk, Position.E1);     //KING
        chessPieces[5][7] = new ChessPiece(Piece.wb, Position.F1);     //BISHOP
        chessPieces[6][7] = new ChessPiece(Piece.wn, Position.G1);     //KNIGHT
        chessPieces[7][7] = new ChessPiece(Piece.wr, Position.H1);     //ROOK

    }

}
