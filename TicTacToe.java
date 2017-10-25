/***********************************************
 * @ file TicTacToe.java
 * @ brief This program allow two players to play TicTacToe.
 * @ author Jianqiu Xu (Tony)
 * @ date October 09, 2017
 ***********************************************/
import java.awt.*;

public class TicTacToe {
    public static void main(String[] args){
        int[][] board = new int[3][3]; //2-D array for 3*3 broad
        int i, j; //loop index
        int numClicks = 0;
        int turn = 1;
        double x = 0.0;
        double y = 0.0;
        double radius;


        //Draw the grid
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setScale(0, 3); //Scale the canvas to 0,3 * 0,3
        for (i = 0; i <= 3; i++) {
            StdDraw.line(i, 0, i, 3);

        }
        for (i = 0; i <= 3; i++) {
            StdDraw.line(0, i, 3, i);

        }

        //Make all the board[x][y] into zero
        for (i = 0; i <= 2; i++){
            for(j = 0; j <= 2; j++){ // j for columns
                board[i][j]=0;
            }
        }

        while(numClicks < 9){
            //Has the mouse been clicked?
            if(StdDraw.mousePressed()){
                //If the mouse is pressed, get the x and y location
                x = StdDraw.mouseX();
                y = StdDraw.mouseY();

                //Whether the space is clicked earlier or not
                if (board[(int)x][(int)y] == 0) {
                    //If the space is not clicked, Draw circle, Odd number turns
                    if (turn == 1) {

                        StdDraw.setPenColor(Color.BLUE);
                        radius = 0.5;
                        StdDraw.circle(Math.floor(x) + 0.5, Math.floor(y) + 0.5, radius);
                        board[(int)x][(int)y] = 1;
                        turn = 2;
                    }
                    //If the space is not clicked, Draw cross, Even number turns
                    else if (turn == 2) {

                        StdDraw.setPenColor(Color.RED);
                        StdDraw.line(Math.floor(x), Math.floor(y), Math.ceil(x), Math.ceil(y));
                        StdDraw.line(Math.floor(x) + 1, Math.floor(y), Math.ceil(x) - 1, Math.ceil(y));
                        board[(int)x][(int)y] = 2;
                        turn = 1;
                    }

                    //pause between receiving each click
                    StdDraw.pause(500);
                    numClicks++;
                }
                //If the space is clicked before, do not draw anything
                else {

                }
            }
        }
    }
}
