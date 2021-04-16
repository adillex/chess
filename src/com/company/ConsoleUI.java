package com.company;


abstract class ConsoleUI implements UI{
    public static void draw(Board board){
        System.out.println();
        for(int i=7 ;i>=-1;i--){
            for(int g=-1;g<8;g++){
                if(g == -1 ){
                    if(i == -1){
                        System.out.print(' ');
                    }else {
                        System.out.print(i + 1);
                    }
                }else if(i == -1 ){
                    System.out.print((char)((int)('a' + g)));
                }
                else if((board.getBoard())[g][i] == null){
                    if ( (i + g)%2==0 ){
                        System.out.print('■');
                    }else{
                        System.out.print('□');
                    }
                }else {
                    if (((board.getBoard())[g][i].getClass()).equals(Pawn.class)) {
                        if (board.getBoard()[g][i].getIsWhite()) {
                            System.out.print('♙');
                        } else {
                            System.out.print('♟');
                        }
                    }else if(board.getBoard()[g][i].getClass().equals(Bishop.class)){
                        if(board.getBoard()[g][i].getIsWhite()){
                            System.out.print('♗');
                        }else{
                            System.out.print('♝');
                        }
                    }else if(board.getBoard()[g][i].getClass().equals(Rook.class)){
                        if(board.getBoard()[g][i].getIsWhite()){
                            System.out.print('♖');
                        }else{
                            System.out.print('♜');
                        }
                    }else if(board.getBoard()[g][i].getClass().equals(Queen.class)){
                        if(board.getBoard()[g][i].getIsWhite()){
                            System.out.print('♕');
                        }else{
                            System.out.print('♛');
                        }
                    }else if(board.getBoard()[g][i].getClass().equals(Knight.class)){
                        if(board.getBoard()[g][i].getIsWhite()){
                            System.out.print('♘');
                        }else{
                            System.out.print('♞');
                        }
                    }else if(board.getBoard()[g][i].getClass().equals(King.class)){
                        if(board.getBoard()[g][i].getIsWhite()){
                            System.out.print('♔');
                        }else{
                            System.out.print('♚');
                        }
                    }
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
