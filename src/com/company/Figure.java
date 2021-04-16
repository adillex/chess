package com.company;

import java.util.Objects;

abstract class Figure implements MoveAblle,Turn {
    private BoardPosition position;
    private boolean isWhite;
    public BoardPosition getPosition() {
        return position;
    }
    public void setPosition(BoardPosition position) {
        this.position = position;
    }
    public boolean getIsWhite() {
        return isWhite;
    }
    public void setIsWhite(boolean white) {
        isWhite = white;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return isWhite == figure.isWhite &&
                Objects.equals(position, figure.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, isWhite);
    }
}