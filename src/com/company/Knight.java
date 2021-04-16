package com.company;

import java.util.ArrayList;
import java.util.List;

class Knight extends Figure{
    @Override
    public boolean possibleMove(BoardPosition position) {
        if(Math.abs(getPosition().getXPossition() - position.getXPossition()) + Math.abs(getPosition().getYPossition() - position.getYPossition()) == 3
                && getPosition().getXPossition()!=position.getXPossition() && getPosition().getYPossition()!=position.getYPossition() &&
                position.getYPossition() < MAX_POSITION && position.getXPossition() < MAX_POSITION &&
                position.getYPossition() >=MIN_POSITION && position.getXPossition() >=MIN_POSITION){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<BoardPosition> trace(BoardPosition position) {
        if(possibleMove(position)) {
            return new ArrayList<BoardPosition>();
        }else{
            throw new RuntimeException("KnightTraceExseption");
        }
    }

    @Override
    public void turnPosition(BoardPosition Position) {
        if(possibleMove(Position)){
            setPosition(Position);
        }else{
            throw new RuntimeException("knight'sException");
        }
    }
    Knight(BoardPosition position,boolean isWhite){
        setPosition(position);
        setIsWhite(isWhite);
    }
}