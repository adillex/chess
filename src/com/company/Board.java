package com.company;
import java.util.List;
class Board {
    private Figure board[][];
    Board(List<Figure> chess){
        board = new Figure[8][8];
        for (int i = 0 ; i<8 ; i++){
            for(int g = 0 ; g<8;g++){
                board[i][g]=null;
            }
        }
        for (int i = 0; i<chess.size(); i++){
            board[chess.get(i).getPosition().getXPossition()][chess.get(i).getPosition().getYPossition()]=chess.get(i);
        }
    }
    public Figure[][] getBoard(){
        return board;
    }
}