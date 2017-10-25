/***********************************************
 * @ file ConnectFour.java
 * @ brief This program allow two players to play ConnectFour.
 * @ author Jianqiu Xu (Tony)
 * @ date October 11, 2017
 ***********************************************/
import java.awt.*;

public class ConnectFour {
    public static void main(String[] args) {

        //Define Array
        int[] columns = new int[7];
        int[][] board = new int[6][7];
        //Declare Variables
        int numClicks = 0;
        int turn = 0;
        int x;

        //Draw board
        StdDraw.setScale(0, 7);
        int i, j;

        StdDraw.setPenColor(Color.BLACK);

        for (i = 0; i < 7; i++) {
            for (j = 0; j < 6; j++) {

                StdDraw.circle(i + 0.5, j + 0.5, 0.5);
            }
        }

        //There is a total of 42 blank circles
        while (numClicks < 42) {
            //When mouse is clicked
            if (StdDraw.mousePressed()) {
                x = (int) Math.floor(StdDraw.mouseX());

                //Max number in a column is 6
                if (columns[x] < 6) {
                    //Draw red circle, Odd number turns
                    if (turn == 0) {
                        StdDraw.setPenColor(Color.RED);
                        StdDraw.filledCircle(x + 0.5, columns[x] + 0.5, 0.5);
                        turn = 1;
                    }
                    //Draw blue circle, Even number turns
                    else if (turn == 1) {
                        StdDraw.setPenColor(Color.BLUE);
                        StdDraw.filledCircle(x + 0.5, columns[x] + 0.5, 0.5);
                        turn = 0;
                    }
                    board[columns[x]][x] = turn;

                    //Pause between receiving each click
                    StdDraw.pause(300);
                    numClicks++;
                    columns[x]++;
                }
            }
        }
    }
}