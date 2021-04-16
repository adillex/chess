package com.company;

import java.util.List;

public interface MoveAblle {
    boolean possibleMove(BoardPosition position);
    List<BoardPosition> trace(BoardPosition position);
    int MAX_POSITION = 8;
    int MIN_POSITION = 0;
}
