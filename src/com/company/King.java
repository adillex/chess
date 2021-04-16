package com.company;

import java.util.ArrayList;
import java.util.List;

class King extends Figure{
    private boolean haveFirstTurn;
    public boolean isHaveFirstTurn() {
        return haveFirstTurn;
    }
    public void setHaveFirstTurn(boolean haveFirstTurn) {
        this.haveFirstTurn = haveFirstTurn;
    }
    @Override
    public boolean possibleMove(BoardPosition Position) {
        if((Position.getYPossition()==getPosition().getYPossition()+1 ||
                Position.getYPossition()==getPosition().getYPossition() ||
                Position.getYPossition()==getPosition().getYPossition()-1) &&
                (Position.getXPossition()==getPosition().getXPossition() ||
                        Position.getXPossition()==getPosition().getXPossition()+1 ||
                        Position.getXPossition()==getPosition().getXPossition()-1 ) &&
                Position.getYPossition() < MAX_POSITION && Position.getXPossition() < MAX_POSITION &&
                Position.getYPossition() >=MIN_POSITION && Position.getXPossition() >=MIN_POSITION){
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
            throw new RuntimeException("KingTraceExseption");
        }
    }

    King(BoardPosition Position, boolean isWhite){
        setPosition(Position);
        setIsWhite(isWhite);
        setHaveFirstTurn(true);
    }
    @Override
    public void setPosition(BoardPosition position){
        super.setPosition(position);
        this.haveFirstTurn=false;
    }
    @Override
    public void turnPosition(BoardPosition Position){
        if(possibleMove(Position)){
            setPosition(Position);
        }else{
            throw new RuntimeException("notValidPosition");
        }
    }
}
