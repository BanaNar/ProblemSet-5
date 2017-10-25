/***********************************************
 * @ file AntPheromoneWalk.java
 * @ brief This program stimulates ant's walking process in a grid without walking to same spots.
 * @ author Jianqiu Xu (Tony)
 * @ date October 10, 2017
 ***********************************************/
import java.awt.*;
import java.util.Random;

public class AntPheromoneWalk {
    public static void main(String[] args) {

        //Draw the grid
        int i, j;

        StdDraw.setPenColor(Color.orange);
        StdDraw.setScale(-1, 31);
        for(i = 0; i <= 30; i++){

            StdDraw.line(i, 0, i, 30);

        }

        for(i = 0; i <= 30; i++){

            StdDraw.line(0, i, 30, i);

        }

        Random rand = new Random();//Stimulate how ant moves

        int a = 15;//Horizontal, Start point
        int b = 15;//Vertical, Start point

        int c = 15;//Horizontal, End point
        int d = 15;//Vertical, End point

        int direction;
        int counter = 0; //Count the steps the ant took
        int[][] grid = new int[30][30];//The 2-D Array for the grid

        //Store 0 into every spaces of the 2-D Array
        for (i = 0; i < 30; i++){ // i for rows
            for(j = 0; j < 30; j++){ // j for columns
                grid[i][j] = 0;
            }
        }

        grid[a][b] = 1; //Store 1 in the start point

        while(c > 1 && c < 29 && d > 1 && d < 29) {//If the ant did not touch the edge
            direction = rand.nextInt(4); //Generate random value among 0, 1, 2, 3, Each represent a direction

            if (direction == 0) { //Move upwards
                if (grid[c][d + 1] == 0) { //If the point has not been walked
                    d++;
                    grid[c][d] = 1;
                    counter++;
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.setPenRadius(0.005);
                    StdDraw.line(a,b,c,d);
                    a=c;
                    b=d;
                }

            }

            if (direction == 1) { //Move downwards
                if (grid[c][d - 1] == 0) { //If the point has not been walked
                    d--;
                    grid[c][d] = 1;
                    counter++;
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.setPenRadius(0.005);
                    StdDraw.line(a,b,c,d);
                    a=c;
                    b=d;
                }

            }

            if (direction == 2) { //Move to left
                if (grid[c - 1][d] == 0) { //If the point has not been walked
                    c--;
                    grid[c][d] = 1;
                    counter++;
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.setPenRadius(0.005);
                    StdDraw.line(a,b,c,d);
                    a=c;
                    b=d;
                }

            }

            if (direction == 3) { //Move to right
                if (grid[c + 1][d] == 0) { //If the point has not been walked
                    c++;
                    grid[c][d] = 1;
                    counter++;
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.setPenRadius(0.005);
                    StdDraw.line(a,b,c,d);
                    a=c;
                    b=d;
                }

            }

            if (grid[c][d + 1] == 1 && grid[c][d - 1] == 1 && grid[c + 1][d] == 1 && grid[c - 1][d] == 1) { //If every direction has been stored 1, the ant stuck and end the program
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(15, 1, "Ant got stuck after " + counter + " steps.");
                break;
            }


        }

        if (c >= 29 || c <= 1 || d >= 29 || d <= 1){//If the ant reached the edges
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(15, 1, "Ant took " + counter + " steps to reach the edge.");
        }


    }
}