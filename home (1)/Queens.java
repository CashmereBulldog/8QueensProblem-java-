// This program solves the classic "8 queens" problem using recursive
// backtracking, printing all solutions.

import java.util.*;

public class Queens {
    public static void main(String[] args) {
        giveIntro();
        Scanner console = new Scanner(System.in);
        System.out.print("What size board do you want to use? ");
        int size = console.nextInt();
        System.out.println();
        Board b = new Board(size);
        //Board b = new BoardFrame(size);
        solve(b);
    }

    // post: explains program to user
    public static void giveIntro() {
        System.out.println("This program solves the classic '8 queens'");
        System.out.println("problem, placing queens on a chessboard so");
        System.out.println("that no two queens threaten each other.");
        System.out.println();
    }

    // Solves the n-queens problem using the given board,
    // prints out all possible ways of arranging n queens
    // on the board such that none can attack each other
    // where n is the size of the board.
    public static void solve(Board b) {
        
        System.out.println(solve(b, 1, 0));
    }
    private static int solve(Board b, int col, int counter) {
        if (col == b.size() + 1) {
            //base case
            b.print();
            return counter + 1;
        } else {
            //recusive case
            for (int row = 1; row <= b.size(); row++) {
                //check if it's safe
                if (b.safe(row, col)) { //Checking possible move
                    //place a queen in next column
                    b.place(row, col);
                
                    //IF so, recur
                    System.out.println(solve(b, col + 1, counter));
                    
                    //safe, recurse; unsafe, remove
                    b.remove(row, col);
                }
            }
        }
        return counter;
    }
}
