package com.company;

import java.util.Objects;

class BoardPosition {
    private int xPossition;
    private int yPossition;
    public int getXPossition() {
        return xPossition;
    }
    public void setXPossition(int xPossition) {
        this.xPossition = xPossition;
    }
    public int getYPossition() {
        return yPossition;
    }
    public void setYPossition(int yPossition) {
        this.yPossition = yPossition;
    }
    BoardPosition(int x , int y){
        xPossition=x;
        yPossition=y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPosition that = (BoardPosition) o;
        return xPossition == that.xPossition &&
                yPossition == that.yPossition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPossition, yPossition);
    }

    @Override
    public String toString() {
        return "BoardPosition{" +
                "xPossition=" + xPossition +
                ", yPossition=" + yPossition +
                '}';
    }
    //    private Vertical xPosition;
//    private Gorizontal yPosition;
//    public Vertical getxPosition() {
//        return xPosition;
//    }
//    public void setxPosition(Vertical xPosition) {
//        this.xPosition = xPosition;
//    }
//    public Gorizontal getyPosition() {
//        return yPosition;
//    }
//    public void setyPosition(Gorizontal yPosition) {
//        this.yPosition = yPosition;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BoardPosition that = (BoardPosition) o;
//        return xPosition == that.xPosition &&
//                yPosition == that.yPosition;
//    }
//
//    @Override
//    public int hashCode() {
//        return 0;
//    }
}
