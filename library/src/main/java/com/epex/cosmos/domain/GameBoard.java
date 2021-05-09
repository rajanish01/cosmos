package com.epex.cosmos.domain;

import com.epex.cosmos.enums.Piece;
import com.epex.cosmos.enums.Position;
import com.epex.cosmos.enums.Side;
import lombok.Data;

@Data
public class GameBoard {

    private ChessPiece[][] chessPieces = new ChessPiece[8][8];

    public GameBoard(Side botAs) {
        if (botAs == Side.WHITE) {
            //pieces[column][row] = XXX
            // SIDE -> BLACK
            chessPieces[0][0] = new ChessPiece(Piece.br1, Position.A8);     //ROOK
            chessPieces[1][0] = new ChessPiece(Piece.bn1, Position.B8);     //KNIGHT
            chessPieces[2][0] = new ChessPiece(Piece.bb1, Position.C8);     //BISHOP
            chessPieces[3][0] = new ChessPiece(Piece.bq, Position.D8);      //QUEEN
            chessPieces[4][0] = new ChessPiece(Piece.bk, Position.E8);      //KING
            chessPieces[5][0] = new ChessPiece(Piece.bb2, Position.F8);     //BISHOP
            chessPieces[6][0] = new ChessPiece(Piece.bn2, Position.G8);     //KNIGHT
            chessPieces[7][0] = new ChessPiece(Piece.br2, Position.H8);     //ROOK

            chessPieces[0][1] = new ChessPiece(Piece.bp1, Position.A7);     //PAWN
            chessPieces[1][1] = new ChessPiece(Piece.bp2, Position.B7);     //PAWN
            chessPieces[2][1] = new ChessPiece(Piece.bp3, Position.C7);     //PAWN
            chessPieces[3][1] = new ChessPiece(Piece.bp4, Position.D7);     //PAWN
            chessPieces[4][1] = new ChessPiece(Piece.bp5, Position.E7);     //PAWN
            chessPieces[5][1] = new ChessPiece(Piece.bp6, Position.F7);     //PAWN
            chessPieces[6][1] = new ChessPiece(Piece.bp7, Position.G7);     //PAWN
            chessPieces[7][1] = new ChessPiece(Piece.bp8, Position.H7);     //PAWN


            //SIDE -> WHITE
            chessPieces[0][6] = new ChessPiece(Piece.wp1, Position.A2);     //PAWN
            chessPieces[1][6] = new ChessPiece(Piece.wp2, Position.B2);     //PAWN
            chessPieces[2][6] = new ChessPiece(Piece.wp3, Position.C2);     //PAWN
            chessPieces[3][6] = new ChessPiece(Piece.wp4, Position.D2);     //PAWN
            chessPieces[4][6] = new ChessPiece(Piece.wp5, Position.E2);     //PAWN
            chessPieces[5][6] = new ChessPiece(Piece.wp6, Position.F2);     //PAWN
            chessPieces[6][6] = new ChessPiece(Piece.wp7, Position.G2);     //PAWN
            chessPieces[7][6] = new ChessPiece(Piece.wp8, Position.H2);     //PAWN

            chessPieces[0][7] = new ChessPiece(Piece.wr1, Position.A1);     //ROOK
            chessPieces[1][7] = new ChessPiece(Piece.wn1, Position.B1);     //KNIGHT
            chessPieces[2][7] = new ChessPiece(Piece.wb1, Position.C1);     //BISHOP
            chessPieces[3][7] = new ChessPiece(Piece.wq, Position.D1);      //QUEEN
            chessPieces[4][7] = new ChessPiece(Piece.wk, Position.E1);      //KING
            chessPieces[5][7] = new ChessPiece(Piece.wb2, Position.F1);     //BISHOP
            chessPieces[6][7] = new ChessPiece(Piece.wn2, Position.G1);     //KNIGHT
            chessPieces[7][7] = new ChessPiece(Piece.wr2, Position.H1);     //ROOK
        } else {
            // SIDE -> WHITE
            chessPieces[0][0] = new ChessPiece(Piece.wr1, Position.A8);     //ROOK
            chessPieces[1][0] = new ChessPiece(Piece.wn1, Position.B8);     //KNIGHT
            chessPieces[2][0] = new ChessPiece(Piece.wb1, Position.C8);     //BISHOP
            chessPieces[3][0] = new ChessPiece(Piece.wq, Position.D8);      //QUEEN
            chessPieces[4][0] = new ChessPiece(Piece.wk, Position.E8);      //KING
            chessPieces[5][0] = new ChessPiece(Piece.wb2, Position.F8);     //BISHOP
            chessPieces[6][0] = new ChessPiece(Piece.wn2, Position.G8);     //KNIGHT
            chessPieces[7][0] = new ChessPiece(Piece.wr2, Position.H8);     //ROOK

            chessPieces[0][1] = new ChessPiece(Piece.wp1, Position.A7);     //PAWN
            chessPieces[1][1] = new ChessPiece(Piece.wp2, Position.B7);     //PAWN
            chessPieces[2][1] = new ChessPiece(Piece.wp3, Position.C7);     //PAWN
            chessPieces[3][1] = new ChessPiece(Piece.wp4, Position.D7);     //PAWN
            chessPieces[4][1] = new ChessPiece(Piece.wp5, Position.E7);     //PAWN
            chessPieces[5][1] = new ChessPiece(Piece.wp6, Position.F7);     //PAWN
            chessPieces[6][1] = new ChessPiece(Piece.wp7, Position.G7);     //PAWN
            chessPieces[7][1] = new ChessPiece(Piece.wp8, Position.H7);     //PAWN


            //SIDE -> BLACK
            chessPieces[0][6] = new ChessPiece(Piece.bp1, Position.A2);     //PAWN
            chessPieces[1][6] = new ChessPiece(Piece.bp2, Position.B2);     //PAWN
            chessPieces[2][6] = new ChessPiece(Piece.bp3, Position.C2);     //PAWN
            chessPieces[3][6] = new ChessPiece(Piece.bp4, Position.D2);     //PAWN
            chessPieces[4][6] = new ChessPiece(Piece.bp5, Position.E2);     //PAWN
            chessPieces[5][6] = new ChessPiece(Piece.bp6, Position.F2);     //PAWN
            chessPieces[6][6] = new ChessPiece(Piece.bp7, Position.G2);     //PAWN
            chessPieces[7][6] = new ChessPiece(Piece.bp8, Position.H2);     //PAWN

            chessPieces[0][7] = new ChessPiece(Piece.br1, Position.A1);     //ROOK
            chessPieces[1][7] = new ChessPiece(Piece.bn1, Position.B1);     //KNIGHT
            chessPieces[2][7] = new ChessPiece(Piece.bb1, Position.C1);     //BISHOP
            chessPieces[3][7] = new ChessPiece(Piece.bq, Position.D1);      //QUEEN
            chessPieces[4][7] = new ChessPiece(Piece.bk, Position.E1);      //KING
            chessPieces[5][7] = new ChessPiece(Piece.bb2, Position.F1);     //BISHOP
            chessPieces[6][7] = new ChessPiece(Piece.bn2, Position.G1);     //KNIGHT
            chessPieces[7][7] = new ChessPiece(Piece.br2, Position.H1);     //ROOK
        }
    }

    public static Position getPosition(int row, int column) throws Exception {
        return Position.fromValue(row, column);
    }

}
