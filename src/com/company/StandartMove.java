package com.company;
public class StandartMove extends Move{
    private BoardPosition start;
    private BoardPosition end;
    StandartMove(BoardPosition start, BoardPosition end){
        this.start = start;
        this.end = end;
    }
    public BoardPosition getStart() {
        return start;
    }
    public void setStart(BoardPosition start) {
        this.start = start;
    }
    public BoardPosition getEnd() {
        return end;
    }
    public void setEnd(BoardPosition end) {
        this.end = end;
    }
}
