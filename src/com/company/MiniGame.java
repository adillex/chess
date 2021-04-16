package com.company;

import java.util.Scanner;

class MiniGame {
    public static void main(String[] args) {
        Game myGame = new Game();
        Scanner sc = new Scanner(System.in);
        while (true) {
            ConsoleUI.draw(new  Board(myGame.getChess()));
            try{
                myGame.Turn();
            }catch (RuntimeException re){
                System.out.println("Invalid value");
            }
        }
    }
}
