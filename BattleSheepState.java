import java.util.ArrayList;

public class BattleSheepState {


    /*Static Variables*/
    final static int EMPTY = -1;
    final static int BLACK = 0;
    final static int WHITE = 1;
    final static int MAX_SHEEP_TOKENS = 16;

    /*Essential Variables*/
    BattleSheepState parentState;
    int currentTurn;    //the current turn
    int[][] board;      // the board itself
    int score;


    int emptySpace;     // empty space on the board
    int blackSheepLeft;  // black sheep's tokens left
    int whiteSheepLeft;  // white sheep tokens left


    BattleSheepState(int[][] board){}

    BattleSheepState(int[][] board, BattleSheepState parent, int nextTurn){

    }


    @Override
    public boolean equals(Object o){
        BattleSheepState s = (BattleSheepState) o;


        return true;
    }

    public ArrayList<BattleSheepState> generateStates(){
        ArrayList<BattleSheepState> states = new ArrayList<>();

        return states;
    }

    public int calculateScore(){
        int score = 0;

        return score;
    }
}
