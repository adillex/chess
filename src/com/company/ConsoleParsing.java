package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class ConsoleParsing {
    private static Scanner sc = new Scanner(System.in);
    public static Move Cin() {
        String a = sc.next();
        List<Integer> b = new ArrayList<Integer>();
        for (String c : a.split("")) {
            b.add((int)(c.charAt(0)));
        }
        if(b.size()==5){
            if (b.get(0) != '0'){
                BoardPosition start = new BoardPosition(b.get(0) - (int) ('a'), b.get(1) - (int) ('0') - 1);
                BoardPosition end = new BoardPosition(b.get(3) - (int) ('a'), b.get(4) - (int) ('0') - 1);
                StandartMove sm = new StandartMove(start, end);
                return sm;
            }else{
                LongCastling lc=new LongCastling();
                return lc;
            }
        }else if(b.size()==3){
            ShortCastling sc = new ShortCastling();
            return sc;
        }
        else{
            throw new RuntimeException();
        }
    }
}
