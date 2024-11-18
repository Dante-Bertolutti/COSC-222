

public class TestClass {

	public static void main(String[] args) {
		
	    //Once your queue-based and stack-based methods are ready,
		//try running these:

		Solver.solveWithQueue("src/main/java/maze1.txt");
		Solver.solveWithQueue("src/main/java/maze2.txt");
		Solver.solveWithQueue("src/main/java/maze3.txt");
		Solver.solveWithQueue("src/main/java/maze4.txt");
		Solver.solveWithQueue("src/main/java/maze5.txt");
		Solver.solveWithQueue("src/main/java/maze6.txt");
		Solver.solveWithStack("src/main/java/maze5.txt");
		Solver.solveWithStack("src/main/java/maze6.txt");

		/*
	    Expected output of above:

		maze1.txt Solution found after 44 iterations.
		The largest size of the queue was 5
		maze2.txt Solution found after 71 iterations.
		The largest size of the queue was 8
		maze3.txt Solution found after 93 iterations.
		The largest size of the queue was 9
		maze4.txt Solution found after 10 iterations.
		The largest size of the queue was 3
		maze5.txt Solution found after 81 iterations.
		The largest size of the queue was 7
		maze6.txt Queue ran out of items after 116 iterations. No solution to maze.
		The largest size of the queue was 11
		maze5.txt Solution found after 39 iterations.
		The largest size of the stack was 21
		maze6.txt Stack ran out of items after 116 iterations. No solution to maze.
		The largest size of the stack was 27

		Your code will be tested on all maze files (perhaps more), using
		queue, stack and priorityQueue methods. The following for-loop will
		run all methods for all 14 files. Feel free to modify this for
		testing purposes.
		*/
		
//		for (int i=1; i <= 14; i++) {
//			Solver.solveWithQueue("maze"+i+".txt");
//			Solver.solveWithStack("maze"+i+".txt");
//			Solver.solveWithPriorityQueue("maze"+i+".txt");
//		}

	}
}
