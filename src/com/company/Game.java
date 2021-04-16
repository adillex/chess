package com.company;

import java.util.ArrayList;
import java.util.List;

class Game {
    private List<Figure> chess = new ArrayList<Figure>();

    private boolean isWhiteTurn;

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    public void setWhiteTurn(boolean whiteTurn) {
        isWhiteTurn = whiteTurn;
    }
    public void nextTurn(){
        if (this.isWhiteTurn){
            this.isWhiteTurn=false;
        }else{
            this.isWhiteTurn=true;
        }
    }
    Game() {
        isWhiteTurn = true;

        King myKing = new King(new BoardPosition(4, 0), true);
        chess.add(myKing);
        myKing = new King(new BoardPosition(4, 7), false);
        chess.add(myKing);

        Pawn myPawn = new Pawn(new BoardPosition(0, 1), true);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(1, 1), true);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(2, 1), true);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(3, 1), true);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(4, 1), true);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(5, 1), true);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(6, 1), true);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(7, 1), true);
        chess.add(myPawn);

        myPawn = new Pawn(new BoardPosition(0, 6), false);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(1, 6), false);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(2, 6), false);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(3, 6), false);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(4, 6), false);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(5, 6), false);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(6, 6), false);
        chess.add(myPawn);
        myPawn = new Pawn(new BoardPosition(7, 6), false);
        chess.add(myPawn);

        Rook myRook = new Rook(new BoardPosition(0, 0), true);
        chess.add(myRook);
        myRook = new Rook(new BoardPosition(7, 0), true);
        chess.add(myRook);
        myRook = new Rook(new BoardPosition(7, 7), false);
        chess.add(myRook);
        myRook = new Rook(new BoardPosition(0, 7), false);
        chess.add(myRook);

        Knight myKnight = new Knight(new BoardPosition(1, 0), true);
        chess.add(myKnight);
        myKnight = new Knight(new BoardPosition(6, 0), true);
        chess.add(myKnight);
        myKnight = new Knight(new BoardPosition(1, 7), false);
        chess.add(myKnight);
        myKnight = new Knight(new BoardPosition(6, 7), false);
        chess.add(myKnight);

        Bishop myBishop = new Bishop(new BoardPosition(2, 0), true);
        chess.add(myBishop);
        myBishop = new Bishop(new BoardPosition(5, 0), true);
        chess.add(myBishop);
        myBishop = new Bishop(new BoardPosition(2, 7), false);
        chess.add(myBishop);
        myBishop = new Bishop(new BoardPosition(5, 7), false);
        chess.add(myBishop);

        Queen myQueen = new Queen(new BoardPosition(3, 0), true);
        chess.add(myQueen);
        myQueen = new Queen(new BoardPosition(3, 7), false);
        chess.add(myQueen);
    }

    public List<Figure> getChess() {
        return chess;
    }

    public Figure figureAt(BoardPosition Position) {
        for (int i = 0; i < chess.size(); i++) {
            if ((chess.get(i)).getPosition().getXPossition() == Position.getXPossition()
                    && (chess.get(i)).getPosition().getYPossition() == Position.getYPossition()) {
                return chess.get(i);
            }
        }
        return null;
    }

    public int findFigure(Figure figure) {
        for (int i = 0; i < chess.size(); i++) {
            if (chess.get(i).equals(figure)) {
                return i;
            }
        }
        return Integer.parseInt(null);
    }
//    private King findKing(boolean isWhite) { //TODO KONEC HODA
//        for (int i = 0; i < chess.size(); i++) {
//            Figure myFigure= chess.get(i);
//            if (chess.get(i) instanceof King) {
//                if(myFigure.getIsWhite() == isWhite){
//                    return (King)chess.get(i);
//                }
//            }
//        }
//        return null;
//    }

    public boolean positionStrike(BoardPosition position, boolean isWhite) {
        for (int i = 0; i < chess.size(); i++) {
            Figure myFigure = chess.get(i);
            if (myFigure.getIsWhite() == isWhite) {
                continue;
            } else {
                if (myFigure.possibleMove(position)) {
                    List<BoardPosition> myTrace = myFigure.trace(position);
                    for (int g = 0; g < myTrace.size(); g++) {
                        if (figureAt(myTrace.get(g)) != null) {
                            break;
                        }
                        if (g == myTrace.size() - 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void Turn() {
        Move m = ConsoleParsing.Cin();
        if (m instanceof StandartMove) {
            StandartMove sm = (StandartMove) m;
            if (figureAt(sm.getStart()) == null) {
                throw new RuntimeException();
            }
            if (figureAt(sm.getStart()).getIsWhite() != isWhiteTurn) {
                throw new RuntimeException("unCorrectFigure");
            }
            if(figureAt(sm.getStart()) instanceof Pawn){
                Pawn timePawn = (Pawn)(figureAt(sm.getStart()));
                if(timePawn.possibleMove(sm.getEnd())){
                    if(figureAt(sm.getEnd()) == null){
                        List<BoardPosition> myTrace = figureAt(sm.getStart()).trace(sm.getEnd());
                        for (int i = 0; i < myTrace.size(); i++) {
                            if (figureAt(myTrace.get(i)) != null) {
                                throw new RuntimeException();
                            }
                        }
                        timePawn.setPosition(sm.getEnd());
                    }else{
                        throw new RuntimeException("notCorrectPawnMove");
                    }
                }else{
                    if(timePawn.possibleEat(sm.getEnd()) && figureAt(sm.getEnd()) != null){
                        chess.remove(findFigure(figureAt(sm.getEnd())));
                        timePawn.setPosition(sm.getEnd());
                    }
                }
            }else {
                List<BoardPosition> myTrace = figureAt(sm.getStart()).trace(sm.getEnd());
                for (int i = 0; i < myTrace.size(); i++) {
                    if (figureAt(myTrace.get(i)) != null) {
                        throw new RuntimeException();
                    }
                }
                if (figureAt(sm.getEnd()) != null) {
                    if (figureAt(sm.getEnd()).getIsWhite() == figureAt(sm.getStart()).getIsWhite()) {
                        throw new RuntimeException();
                    } else {
                        chess.remove(findFigure(figureAt(sm.getEnd())));
                        (figureAt(sm.getStart())).turnPosition(sm.getEnd());
                    }
                } else {
                    (figureAt(sm.getStart())).turnPosition(sm.getEnd());
                }
            }
        } else if (m instanceof Castling) {
            BoardPosition CastlingPosition1,CastlingPosition2,kingPosition,rookPosition;
            if (m instanceof ShortCastling) { // ShortCastling
                if (isWhiteTurn) {// WhiteShortCastling
                    CastlingPosition1 = new BoardPosition(6, 0);
                    CastlingPosition2 = new BoardPosition(5, 0);
                    kingPosition = new BoardPosition(4, 0);
                    rookPosition = new BoardPosition(7, 0);
                } else {// BlackShortCastling
                    CastlingPosition1 = new BoardPosition(6, 7);
                    CastlingPosition2 = new BoardPosition(5, 7);
                    kingPosition = new BoardPosition(4, 7);
                    rookPosition = new BoardPosition(7, 7);
                }
            } else { //LongCastling
                if (isWhiteTurn) { //WhitelongCastling
                    CastlingPosition1 = new BoardPosition(2, 0);
                    CastlingPosition2 = new BoardPosition(3, 0);
                    kingPosition = new BoardPosition(4, 0);
                    rookPosition = new BoardPosition(0, 0);
                } else { //BlacklongCastling
                    CastlingPosition1 = new BoardPosition(2, 7);
                    CastlingPosition2 = new BoardPosition(3, 7);
                    kingPosition = new BoardPosition(4, 7);
                    rookPosition = new BoardPosition(0, 7);
                }
            }
            if (figureAt(kingPosition) instanceof King) {
                if (figureAt(kingPosition).getIsWhite() == isWhiteTurn()) {
                    if (!(((King) figureAt(kingPosition)).isHaveFirstTurn())) {
                        throw new RuntimeException("KingHaveNotFirstTurn");
                    }
                } else {
                    throw new RuntimeException("NotCorrectKingColor");
                }
            } else {
                throw new RuntimeException("KingHaveNotFind");
            } //check, all right with king???
            if (figureAt(rookPosition) instanceof Rook) {
                if (figureAt(rookPosition).getIsWhite() == isWhiteTurn()) {
                    if (!(((Rook) (figureAt(rookPosition))).isHaveFirstTurn())) {
                        throw new RuntimeException("RookHaveNotFirstTurn");
                    }
                } else {
                    throw new RuntimeException("NotCorrectKingColor");
                }
            } else {
                throw new RuntimeException("RookHaveNotFind");
            }//check, all right with rook???
            if (figureAt(CastlingPosition1) == null
                    && figureAt(CastlingPosition2) == null) {
                if (positionStrike(CastlingPosition1, isWhiteTurn) &&
                        positionStrike(CastlingPosition2, isWhiteTurn) &&
                        positionStrike(kingPosition, isWhiteTurn)) {
                    figureAt(kingPosition).setPosition(CastlingPosition1);
                    figureAt(rookPosition).setPosition(CastlingPosition2);
                }else{
                    throw new RuntimeException("NotDefenedPosition");
                }
            }else{
                throw new RuntimeException("PositionsAreOccupied");
            }
        }
        //if()
        nextTurn();
    }
}