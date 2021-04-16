package com.company;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Figure{
    private boolean haveFirstTurn;
    public boolean isHaveFirstTurn() {
        return haveFirstTurn;
    }
    public void setHaveFirstTurn(boolean haveFirstTurn) {
        this.haveFirstTurn = haveFirstTurn;
    }
    @Override
    public boolean possibleMove(BoardPosition Position) {
        if (getIsWhite()){
            if(haveFirstTurn &&
                    (Position.getYPossition()==getPosition().getYPossition()+2 &&
                            Position.getXPossition()==getPosition().getXPossition() &&
                            Position.getYPossition() < MAX_POSITION )){
                return true;
            }else if((Position.getYPossition()==getPosition().getYPossition()+1 &&
                    Position.getXPossition()==getPosition().getXPossition() &&
                    Position.getYPossition() < MAX_POSITION )){
                return true;
            }else{
                return false;
            }
        }else{
            if(haveFirstTurn &&
                    (Position.getYPossition()==getPosition().getYPossition()-2 &&
                            Position.getXPossition()==getPosition().getXPossition() &&
                            Position.getYPossition() >= MIN_POSITION )){
                return true;
            }else if(Position.getYPossition()==getPosition().getYPossition()-1 &&
                    Position.getXPossition()==getPosition().getXPossition() &&
                    Position.getYPossition()>=MIN_POSITION){
                return true;
            }else{
                return false;
            }
        }
    }
    public boolean possibleEat(BoardPosition position){
        if(getIsWhite()){
            if(Math.abs(position.getXPossition() - getPosition().getXPossition()) == 1
                    && position.getYPossition()-getPosition().getYPossition() == 1){
                return true;
            }else{
                return false;
            }
        }else{
            if(Math.abs(position.getXPossition() - getPosition().getXPossition()) == 1
                    && position.getYPossition()-getPosition().getYPossition() == -1){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public List<BoardPosition> trace(BoardPosition position) {
        if(possibleMove(position)) {
            List<BoardPosition> myTrace = new ArrayList<>();
            if(Math.abs(position.getYPossition() - getPosition().getYPossition()) == 2){
                if(getIsWhite()){
                    myTrace.add(new BoardPosition(getPosition().getXPossition(),getPosition().getYPossition()+1));
                }else{
                    myTrace.add(new BoardPosition(getPosition().getXPossition(),getPosition().getYPossition()-1));
                }
            }
            System.out.println(myTrace);
            return myTrace;
        }else{
            throw new RuntimeException("invalid");
        }
    }

    Pawn(BoardPosition Position, boolean isWhite){
        setPosition(Position);
        setIsWhite(isWhite);
        setHaveFirstTurn(true);
    }
    @Override
    public void turnPosition(BoardPosition Position){
        if(possibleMove(Position)){
            setPosition(Position);
            this.haveFirstTurn=false;
        }else{
            throw new RuntimeException();
        }
    }
}
