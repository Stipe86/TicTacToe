import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nLet's play tic tac toe");

        char[][] board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]= '_';
            }
        }

        printBoard(board);

        for (int i = 0; i < 9; i++) {
            if (i%2==0) {
            System.out.println("Turn: X");
            int[] spot = askUser(board);
                int row = spot[0];
                int column = spot[1];
                board[row][column]='X';
                printBoard(board);
                if (checkXWin(board)){
                    break;
                }

            }

            else {
                System.out.println("Turn: O");
                int[] spot = askUser(board);
                int row = spot[0];
                int column = spot[1];
                board[row][column]='O';
                printBoard(board);
                if (checkOWin(board)){
                    break;
                }

            }

            if (i==8 && !checkXWin(board) && !checkOWin(board)) {
                System.out.println("It is a draw.");
            }

        }

        scan.close();

    }


    /**
     * Function name - printBoard()
     * @param board (char[][])
     *
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *    - separate each row by two lines.
     *    - each row precedes a tab of space
     *    - each character in the grid has one space from the other character
     */
    
    public static void printBoard (char[][] board) {
        System.out.print("\n");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("\t "+board[i][j]+" ");
            }
            System.out.print("\n");
            System.out.print("\n");
            
        }
    }


    /**
     * Function name -- askUser
     * @param board (char[][] board)
     * @return spot (int[])
     *
     * Inside the function <------
     *  1. Asks the user: - pick a row and column number:
     *  2. If the spot is taken, ask the user to choose again. <----
     *  3. Return the row and column in an int[] array.
     *
     */

    public static int[] askUser (char[][] board) {
        System.out.print("- pick a row and column number: ");
        int row = scan.nextInt();
        int column = scan.nextInt();

             while (row < 1 || row > 3 || column < 1 || column > 3) {

                 System.out.print("- try again");
                 row = scan.nextInt();
                 column = scan.nextInt();
             }

        switch (row) {
            case 1 : row = 0; break;
            case 2 : row = 1; break;
            case 3 : row = 2; break;
            default : row = 404;
        }
        switch (column) {
            case 1 : column = 0; break;
            case 2 : column = 1; break;
            case 3 : column = 2; break;
            default: column = 404;
        }

        while (board[row] [column]!='_') {
            System.out.print("- try again");
            row = scan.nextInt();
            column = scan.nextInt();


            while (row < 1 || row > 3 || column < 1 || column > 3) {

                System.out.print("- try again");
                row = scan.nextInt();
                column = scan.nextInt();
            }



            switch (row) {
                case 1 : row = 0; break;
                case 2 : row = 1; break;
                case 3 : row = 2; break;
                default : row = 404;
            }
            switch (column) {
                case 1 : column = 0; break;
                case 2 : column = 1; break;
                case 3 : column = 2; break;
                default: column = 404;
            }

        }

            int[] spot = {row, column};

            return spot;

    }


    public static boolean checkXWin (char[][] board) {
        boolean xWins=false;
        if (board[0][0]=='X' && board[1][1]=='X'&& board[2][2]=='X'){
            System.out.println("X Wins");
            xWins=true;
        }
        else if (board[0][2]=='X' && board[1][1]=='X'&& board[2][0]=='X') {
            System.out.println("X Wins");
            xWins=true;
        }
        else if (board[0][0]=='X' && board[0][1]=='X'&& board[0][2]=='X') {
            System.out.println("X Wins");
            xWins=true;
        }
        else if (board[1][0]=='X' && board[1][1]=='X'&& board[1][2]=='X') {
            System.out.println("X Wins");
            xWins=true;
        }
        else if (board[2][0]=='X' && board[2][1]=='X'&& board[2][2]=='X') {
            System.out.println("X Wins");
            xWins=true;
        }
        else if (board[0][0]=='X' && board[1][0]=='X'&& board[2][0]=='X') {
            System.out.println("X Wins");
            xWins=true;
        }
        else if (board[0][1]=='X' && board[1][1]=='X'&& board[2][1]=='X') {
            System.out.println("X Wins");
            xWins=true;
        }
        else if (board[0][2]=='X' && board[1][2]=='X'&& board[2][2]=='X') {
            System.out.println("X Wins");
            xWins=true;
        }

        return xWins;


    }

    public static boolean checkOWin (char[][] board) {
        boolean oWins=false;
        if (board[0][0]=='O' && board[1][1]=='O'&& board[2][2]=='O'){
            System.out.println("O Wins");
            oWins=true;
        }
        else if (board[0][2]=='O' && board[1][1]=='O'&& board[2][0]=='O') {
            System.out.println("O Wins");
            oWins=true;
        }
        else if (board[0][0]=='O' && board[0][1]=='O'&& board[0][2]=='O') {
            System.out.println("O Wins");
            oWins=true;
        }
        else if (board[1][0]=='O' && board[1][1]=='O'&& board[1][2]=='O') {
            System.out.println("O Wins");
            oWins=true;
        }
        else if (board[2][0]=='O' && board[2][1]=='O'&& board[2][2]=='O') {
            System.out.println("O Wins");
            oWins=true;
        }
        else if (board[0][0]=='O' && board[1][0]=='O'&& board[2][0]=='O') {
            System.out.println("O Wins");
            oWins=true;
        }
        else if (board[0][1]=='O' && board[1][1]=='O'&& board[2][1]=='O') {
            System.out.println("O Wins");
            oWins=true;
        }
        else if (board[0][2]=='O' && board[1][2]=='O'&& board[2][2]=='O') {
            System.out.println("O Wins");
            oWins=true;
        }

        return oWins;

    }
}
