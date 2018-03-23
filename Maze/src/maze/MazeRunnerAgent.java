package maze;

public class MazeRunnerAgent extends Thread {
	Maze maze;
	int x, y;
	int goalX, goalY;
	
	public MazeRunnerAgent(Maze maze, int goalX, int goalY) {
		this.maze = maze;
		this.goalX = goalX;
		this.goalY = goalY;
	}
	
	public boolean sense(int x, int y) {
		return maze.isEmpty(x, y);
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
		maze.addPoint(x, y);
	}
	
        @Override
	public void run() {
		
	}
}
