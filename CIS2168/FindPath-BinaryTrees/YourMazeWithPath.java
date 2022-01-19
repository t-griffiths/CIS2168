import java.util.*;
import java.awt.Point;
import java.util.LinkedList;

//dept frist
//recursive


public class YourMazeWithPath
{
    private InputGraphicMaze maze;
    private int R, C;
  //  YOU'LL NEED TO ADD MORE CODE HERE!!!!!!!
    private int [][] V;
    //2d aray to store if node was visited or not


    public YourMazeWithPath()
    {
        // an R rows x C columns maze
        maze = new InputGraphicMaze();
        R=maze.Rows();
        C=maze.Cols();

        V = new int [R +1][C +1];
        //taken from MyMazeWithPath ^. Makes array 1 row and 1 column bigger than size to avoid out of bounds exception
        V[1][1] = 1; //set first spot to visited

        // Path holds the cells of the path
        LinkedList<Point> Path = new LinkedList<Point>();
        // Create the path
        CreatePath(maze, 1, 1, R, C, Path);
        // show the path in the maze
        maze.showPath(Path);
    }

    // Creates the path through maze, starting at cell (srow, scol)
    // and ending at cell (erow, ecol)
    // algorithm follows each path then retracts and tries a different one when it hits a wall
    // keeps doing this until path found
    public boolean CreatePath(InputGraphicMaze maze,
                              int srow, int scol, int erow, int ecol, LinkedList<Point> L) {
        //    YOUR CODE FOR THE PATH GENERATION GOES HERE!!!!!!!
        Point u = new Point (srow,scol);
        int r = srow; //r = starting row
        int c = scol; //c = starting column
        int R = maze.Rows(); //R = total rows
        int C = maze.Cols(); //C = total columns
        boolean done = false; //initialize done as false

        //if current x == final x and if current y == final y
            if (r == R && c == C) {
                done = true;
            } else { //if end node hasn't been reached yet,
                // if node is in row greater than one, node above it hasnt been visted yet, and is able to go up,
                if (!done && (r > 1) && (V[r - 1][c] != 1) && (maze.can_go(r, c, 'U'))) {
                    //can only move up if in at least second row, because first row has barrier above it
                    V[r - 1][c] = 1; //set the above node to visited
                    done = CreatePath(maze, r - 1, c, R, C, L);
                    //recursively call CreatePath on the node above the current one
                }
                //if node is in row less than last row, node below it hasnt been visted yet, and is able to go down,
                if (!done && (r < R) && (V[r + 1][c] != 1) && (maze.can_go(r, c, 'D'))) {
                    //can only move down if row is less than final row, becuase last row has barrier below it
                    V[r + 1][c] = 1; //set below node to visited
                    done = CreatePath(maze, r + 1, c, R, C, L);
                    //recursively call CreatePath on the node below the current one
                }
                //if node is in column greater than one, node to left of it hasnt been visited, and is able to move left,
                if (!done && (c > 1) && (V[r][c - 1] != 1) && (maze.can_go(r, c, 'L'))) {
                    //can only move if left if column in at least second column because first column has barrier to left
                    V[r][c - 1] = 1;
                    done = CreatePath(maze, r, c - 1, R, C, L);
                    //recursively call CreatePath on the node to the left of the current one

                }
                //if node is in column less than last column, node to the right hasnt been visted yet, and is able to move right,
                if (!done && (c < C) && (V[r][c + 1] != 1) && (maze.can_go(r, c, 'R'))) {
                    //can only move right if less than final column becasue final columm has barrier to right
                    V[r][c + 1] = 1;
                    done = CreatePath(maze, r, c + 1, R, C, L);
                    //recursively call CreatePath on the node to the right of the current one

                }
            }
        if (done) {
            L.push(u); //populates L with final path
        }
        return done;
    }

    public static void main(String[] args) {
        new YourMazeWithPath();
    }
}



