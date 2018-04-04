package maze;

import java.util.ArrayList;
import java.util.List;

public class MazeNode extends Node {

    public MazeNode(Node parent, MazeState state, double unitaryCost) {
        super(parent, state, unitaryCost);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Node> successors() {
        // TODO Auto-generated method stub
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
        return String.format("[%s, g: %.2f, f: %.4f, %s]", state.toString(), cost, f(), state.description);
    }

    @Override
    public boolean equals(Object obj) {
        MazeNode node = (MazeNode) obj;
        return (node.state.posX == state.posX && node.state.posY == state.posY
                && node.f() == f());
    }

    public void mazePath() throws InterruptedException {
        if (parent != null) {
            ((MazeNode) parent).mazePath();
        }
        state.maze.addPoint(state.posX, state.posY);
        state.maze.display();
        Thread.sleep(215);
    }

}
