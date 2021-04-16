package com.company;

import java.util.ArrayList;
import java.util.List;

class Bishop extends Figure {
    @Override
    public boolean possibleMove(BoardPosition Position) {
        if((getPosition().getXPossition()+getPosition().getYPossition() == Position.getXPossition()+Position.getYPossition() ||
                getPosition().getXPossition()-getPosition().getYPossition() == Position.getXPossition()-Position.getYPossition())&&
                Position.getXPossition() < MAX_POSITION && Position.getYPossition() < MAX_POSITION &&
                Position.getXPossition() >= MIN_POSITION && Position.getYPossition() >=MIN_POSITION ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<BoardPosition> trace(BoardPosition position) {
        if(possibleMove(position)) {
            List<BoardPosition> myTrace = new ArrayList<>();
            if (getPosition().getXPossition() < position.getXPossition()
                    && getPosition().getYPossition() < position.getYPossition()){
                int a = getPosition().getXPossition();
                int b = getPosition().getYPossition();
                while (a<(position.getXPossition()-1) && b <(position.getYPossition()-1)){
                    a++;
                    b++;
                    BoardPosition position1 = new BoardPosition(a,b);
                    myTrace.add(position1);
                }
            }else if (getPosition().getXPossition() > position.getXPossition()
                    && getPosition().getYPossition() > position.getYPossition()){
                int a = getPosition().getXPossition();
                int b = getPosition().getYPossition();
                while (a > (position.getXPossition()+1) && b > (position.getYPossition()+1)){
                    a--;
                    b--;
                    BoardPosition position1 = new BoardPosition(a,b);
                    myTrace.add(position1);
                }
            }else if(getPosition().getXPossition() > position.getXPossition()
                    && getPosition().getYPossition() < position.getYPossition()){
                int a = getPosition().getXPossition();
                int b = getPosition().getYPossition();
                while (a > (position.getXPossition()+1) && b < (position.getYPossition()-1)) {
                    a--;
                    b++;
                    BoardPosition position1 = new BoardPosition(a, b);
                    myTrace.add(position1);
                }
            }else if(getPosition().getXPossition() < position.getXPossition()
                    && getPosition().getYPossition() > position.getYPossition()) {
                int a = getPosition().getXPossition();
                int b = getPosition().getYPossition();
                while (a < (position.getXPossition() - 1) && b > (position.getYPossition() + 1)) {
                    a++;
                    b--;
                    BoardPosition position1 = new BoardPosition(a, b);
                    myTrace.add(position1);
                }
            }
            else{
                throw new RuntimeException();
            }
            System.out.println(myTrace);
            return myTrace;
        }else{
            throw new RuntimeException("invalid");
        }
    }

    @Override
    public void turnPosition(BoardPosition Position) {
        if(possibleMove(Position)){
            setPosition(Position);
        }else{
            throw new RuntimeException("InvalidSyntax");
        }
    }
    Bishop(BoardPosition Position , Boolean isWhite){
        setPosition(Position);
        setIsWhite(isWhite) ;
    }
}