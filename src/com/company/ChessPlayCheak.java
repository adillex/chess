package com.company;
import java.util.Scanner;
public class ChessPlayCheak {
    public static void main(String[] args) {
        int a, b;
        boolean isWhite;
        Scanner scanner = new Scanner(System.in);
        a=scanner.nextInt();
        b=scanner.nextInt();
        isWhite=scanner.nextBoolean();
        BoardPosition Position = new BoardPosition(a,b);
        Rook myRook = new Rook(Position,isWhite);
        a=scanner.nextInt();
        b=scanner.nextInt();
        Position = new BoardPosition(a,b);
        while (true) {
            try {
                myRook.turnPosition(Position);
                break;
            } catch (Exception RuntimeExseption) {
                System.out.println("not valid");
                a=scanner.nextInt();
                b=scanner.nextInt();
                Position = new BoardPosition(a,b);
                continue;
            }
        }
        System.out.println(myRook.getPosition().getXPossition());
        System.out.println(myRook.getPosition().getYPossition());
    }
}