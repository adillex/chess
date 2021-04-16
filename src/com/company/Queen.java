package com.company;

import java.util.List;

class Queen extends Figure{

    @Override
    public boolean possibleMove(BoardPosition position) {
        Bishop miniBishop = new Bishop(getPosition(),getIsWhite());
        if (miniBishop.possibleMove(position)){
            return true;
        }else {
            Rook miniRook = new Rook(getPosition(),getIsWhite());
            if(miniRook.possibleMove(position)){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public List<BoardPosition> trace(BoardPosition position) {
        Bishop miniBishop = new Bishop(getPosition(),getIsWhite());
        Rook miniRook = new Rook(getPosition(),getIsWhite());
        if(miniBishop.possibleMove(position)){
            return miniBishop.trace(position);
        }else if (miniRook.possibleMove(position)){
            return miniRook.trace(position);
        }else{
            throw new RuntimeException("Queen'sTraceException");
        }
    }

    @Override
    public void turnPosition(BoardPosition Position) {
        if(possibleMove(Position)){
            setPosition(Position);
        }else{
            throw new RuntimeException("queen's exseption");
        }

    }
    Queen(BoardPosition Position , boolean isWhite){
        setPosition(Position);
        setIsWhite(isWhite);
    }
}
