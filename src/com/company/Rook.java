package com.company;

import java.util.ArrayList;
import java.util.List;

class Rook extends Figure{
    private boolean haveFirstTurn;
    public boolean isHaveFirstTurn() {
        return haveFirstTurn;
    }
    public void setHaveFirstTurn(boolean haveFirstTurn) {
        this.haveFirstTurn = haveFirstTurn;
    }
    Rook(BoardPosition Position , boolean isWhite){
        setPosition(Position);
        setIsWhite(isWhite);
        this.haveFirstTurn=true;
    }
    @Override
    public boolean possibleMove(BoardPosition Position) {
        if ((Position.getXPossition()==getPosition().getXPossition() ||
                Position.getYPossition()==getPosition().getYPossition()) &&
                !(Position.getXPossition()==getPosition().getXPossition() &&
                        Position.getYPossition()==getPosition().getYPossition()) &&
                Position.getYPossition() < MAX_POSITION && Position.getXPossition() < MAX_POSITION &&
                Position.getYPossition() >=MIN_POSITION && Position.getXPossition() >=MIN_POSITION){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<BoardPosition> trace(BoardPosition position) {
        if(possibleMove(position)){
            List<BoardPosition> myTrace = new ArrayList<>();
            if( getPosition().getXPossition() == position.getXPossition()){
                if( getPosition().getYPossition() < position.getYPossition()){
                    int a = getPosition().getXPossition();
                    int b = getPosition().getYPossition();
                    while(b < (position.getYPossition()-1)){
                        b++;
                        BoardPosition tracePart = new BoardPosition(a,b);
                        myTrace.add(tracePart);
                    }
                }else {
                    int a = getPosition().getXPossition();
                    int b = getPosition().getYPossition();
                    while(b > (position.getYPossition()+1)){
                        b--;
                        BoardPosition tracePart = new BoardPosition(a,b);
                        myTrace.add(tracePart);
                    }
                }
            }else if(position.getYPossition() == getPosition().getYPossition()){
                if(getPosition().getXPossition() < position.getXPossition()){
                    int a = getPosition().getXPossition();
                    int b = getPosition().getYPossition();
                    while(a < (position.getXPossition()-1)){
                        a++;
                        BoardPosition tracePart = new BoardPosition(a,b);
                        myTrace.add(tracePart);
                    }
                }else{
                    int a = getPosition().getXPossition();
                    int b = getPosition().getYPossition();
                    while(a > (position.getXPossition()+1)){
                        a--;
                        BoardPosition tracePart = new BoardPosition(a,b);
                        myTrace.add(tracePart);
                    }
                }
            }
            else{
                throw new RuntimeException();
            }
            System.out.println(myTrace);
            return myTrace;
        }else{
            throw new RuntimeException();
        }
    }
    @Override
    public void setPosition(BoardPosition position){
        super.setPosition(position);
        this.haveFirstTurn=false;
    }
    @Override
    public void turnPosition(BoardPosition Position) {
        if(possibleMove(Position)){
            setPosition(Position);
        }else{
            throw new RuntimeException("notValidPosition");
        }
    }
}