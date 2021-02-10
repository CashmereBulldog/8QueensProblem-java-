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
        // Board b = new BoardFrame(size);
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
        solve(b, 1);
    }
    
    private static void solve(Board b, int col) {
        if (col == b.size() + 1) {
            b.print();
        } else {
            for (int i = 1; i <= b.size(); i++) {
                if (b.safe(i, col)) {
                    b.place(i, col);
                    solve(b, col + 1);
                    b.remove(i, col);
                }
            }
        }
    }
    
}
