package maze;

import java.util.ArrayList;
import java.util.List;

public class MazeState {
    
    Maze maze;
    int posX, posY, destX, destY;
    double h;
    String description;

    public MazeState(Maze maze, int posX, int posY, String description) {
        this.maze = maze;
        this.destX = maze.getDestinationX();
        this.destY = maze.getDestinationY();
        this.posX = posX;
        this.posY = posY;
        h = heuristic();
        this.description = description;
        // TODO Auto-generated constructor stub
    }
    
    public boolean isGoal(){
        return (posX == destX && posY == destY);
    }
    
    public double heuristic(){
        return Math.sqrt(Math.pow((posX - destX), 2) + Math.pow((posY - destY), 2));
    }
    
    public List<MazeState> expand(){
        List<MazeState> ret = new ArrayList();
        if(maze.isEmpty(posX + 1, posY)){
            ret.add(new MazeState(maze, posX + 1, posY, "Right"));
        }
        if(maze.isEmpty(posX - 1, posY)){
            ret.add(new MazeState(maze, posX - 1, posY, "Left"));
        }
        if(maze.isEmpty(posX, posY + 1)){
            ret.add(new MazeState(maze, posX, posY + 1, "Down"));
        }
        if(maze.isEmpty(posX, posY - 1)){
            ret.add(new MazeState(maze, posX, posY - 1, "Up"));
        }
        return ret;
    }
    
    @Override
    public String toString(){
        return String.format("PosX: %d, PosY: %d, h: %.4f", posX, posY, h);
    }
    
}
