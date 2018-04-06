package maze;

import java.util.ArrayList;
import java.util.List;

public class MazeNode extends Node {

    public MazeNode(Node parent, MazeState state, double unitaryCost) {
        super(parent, state, unitaryCost);
    }

    @Override
    public List<Node> successors() {
        List<Node> ret = new ArrayList();
        List<MazeState> nextStates = state.expand();
        for (MazeState nextState : nextStates) {
            ret.add(new MazeNode(this, nextState, 1));
        }
        return ret;
    }

    public double f() {
        return this.cost + state.h;
    }

    @Override
    public String toString() {
        return String.format("[%s, g: %.2f, f: %.4f, %s]", //For debugging
                state.toString(), cost, f(), state.description);
    }

    //Compares if 2 nodes are equal, considering the position and the f() value
    @Override
    public boolean equals(Object obj) {
        MazeNode node = (MazeNode) obj;
        return (node.state.posX == state.posX && node.state.posY == state.posY
                && node.f() == f());
    }

    //Method to print the path in the maze
    public void mazePath() throws InterruptedException {
        if (parent != null) {
            ((MazeNode) parent).mazePath();
        }
        state.maze.addPoint(state.posX, state.posY);
        state.maze.display();
        //The thread sleeps so that the points can be seen one by one
        Thread.sleep(215);
    }

}
