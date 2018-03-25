package maze;

public class MazeRunner {

    public static void main(String[] args) {
        int x = args.length >= 1 ? Integer.parseInt(args[0]) : 8;
        int y = args.length == 2 ? Integer.parseInt(args[1]) : 8;
        Maze maze = new Maze(x, y, 1, 1, 31, 15);
        maze.addOption(31, 15);
        maze.addOption(26, 10);
        maze.addPoint(1, 1);
        maze.display();

        MazeRunnerAgent runner = new MazeRunnerAgent(maze, 31, 15);
        runner.start();

    }
}
