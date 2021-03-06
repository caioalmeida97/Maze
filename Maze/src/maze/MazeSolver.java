package maze;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MazeSolver {

    public static void main(String[] args) throws InterruptedException {
        int x = args.length >= 1 ? Integer.parseInt(args[0]) : 8;
        int y = args.length == 2 ? Integer.parseInt(args[1]) : 8;

        //Starting point
        int posX = 1, posY = 1;
        //Creates the maze: starting point (1, 1) and destination (31, 15)
        Maze maze = new Maze(x, y, 1, 1, 31, 15);
//        maze.addOption(31, 15);
        maze.addPoint(posX, posY);
        maze.display();
        MazeNode root = new MazeNode(null, new MazeState(maze, posX, posY, "Start"), 0);
        MazeSolver solver = new MazeSolver();
        Node result = solver.aStar(root);
        if (result != null) {
            ((MazeNode) result).mazePath();
            System.out.printf("The path is shown above, with a total of %.0f steps :)\n", result.cost);
        }
    }

    public Node aStar(Node root) {
        LinkedList<Node> fringe = new LinkedList();
        fringe.add(root);

        do {
            Node node = fringe.remove(0);
            if (node.state.isGoal()) {
                return node;
            } else {
                List<Node> temp = node.successors();
                for (Node successor : temp) {
                    int fsize = fringe.size();
                    for (ListIterator<Node> iterator = fringe.listIterator(); iterator.hasNext();) {
                        if (((MazeNode) successor).f() <= ((MazeNode) iterator.next()).f()) {
                            if (!fringe.contains(successor)) {
                                iterator.previous();
                                iterator.add(successor);
                            }
                        }
                    }
                    if (!fringe.contains(successor)) {
                        fringe.add(successor);
                    }
                }
            }
        } while (true);
    }
}
