// Breath-first  traversal for the path.
//not recursive
import java.util.*;
import java.awt.Point;
import java.util.LinkedList;

public class MyMazeWithPath
{
    private InputGraphicMaze maze;
    private int R, C;
    private int[][] V; //visited 2d array

    public MyMazeWithPath()
    {
        // an R rows x C columns maze
        maze = new InputGraphicMaze();
        R=maze.Rows(); //total rows
        C=maze.Cols(); //total colums
        V=new int[R+1][C+1];
        for (int i=1; i<=R; i++)
            for (int j=1; j<=C; j++) V[i][j]=0;
        // Path holds the cells of the path
        LinkedList<Point> Path = new LinkedList<Point>();
        //Create the path
        CreatePath(maze, 1, 1, R, C, Path);
        // show the path in the maze
        maze.showPath(Path);
    }

    //breadth first searches for the shortest path through the maze
    public boolean CreatePath(InputGraphicMaze maze,
                              int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {
        int r=srow, c=scol, //r = starting row     c = starting column
                R=maze.Rows(), C=maze.Cols(); //stores length of rows/columns
        int size=R*C+1;  //size stores area of maze
        Point[] P=new Point[size]; //new array size of area of maze
        boolean done=false; //initialize done as false
        V[srow][scol]=1; //sets coords of starting node to visited
        int scell=(srow-1)*C+scol; //starting cell
        P[scell]=new Point(0,0); //set starting cells cords to 0,0
        Point u=new Point(r, c); //new point u
        LinkedList<Point> Q=new LinkedList<Point>(); //linkedlist of type Point stores que
        Q.add(u); //add new point U to linked list
        while ((Q.size()!=0)&&(!done)) //while que isnt done and 'done' is true
        {
            u=Q.remove(); //take current node out of que
            r=(int) u.getX(); c=(int) u.getY(); //add next coordinates to que
            if ((r==erow)&&(c==ecol)){ // if x is end row and y is end column
                done=true;
            }
            else //if current node isnt end coord
            {
                //if x is greater than one and coords haven't been visited and path can go up,
                if ((r>1)&&(V[r-1][c]!=1)&&(maze.can_go(r, c,'U'))){
                V[r-1][c]=1; //set node to visited
                P[(r-2)*C+c]=u;
                Q.add(new Point(r-1, c));}
                if ((c<C)&&(V[r][c+1]!=1)&&(maze.can_go(r, c,'R'))){
                //if y is less than max y and coords haven't been visited and path can go right,
                V[r][c+1]=1;
                P[(r-1)*C+c+1]=u;
                Q.add(new Point(r, c+1));}
                if ((r<R)&&(V[r+1][c]!=1)&&(maze.can_go(r, c, 'D'))){
                //if x is less than max x and coords haven't been visited and path can go down,
                V[r+1][c]=1;
                P[r*C+c]=u;
                Q.add(new Point(r+1, c));}
                if ((c>1)&&(V[r][c-1]!=1)&&(maze.can_go(r, c, 'L'))){
                //if x is greater than one and coords haven't been visited and path can go left,
                V[r][c-1]=1;
                P[(r-1)*C+c-1]=u;
                Q.add(new Point(r, c-1));}
            }
        } //end of while
        while (!u.equals(P[scell]))
        {
            r=(int) u.getX(); c=(int) u.getY();
            L.addFirst(u); u=P[(r-1)*C+c];
        }
        return done;
    }

    public static void main(String[] args) {new MyMazeWithPath();}
}

