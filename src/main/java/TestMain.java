import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class TestMain {

	//Dante Bertolutti - 300253505
	public static void main(String[] args) throws FileNotFoundException {

		Graph[] g = new Graph[6];
		g[0] = readGraph("src/main/java/small1");
		g[1] = readGraph("src/main/java/small2");
		g[2] = readGraph("src/main/java/medium1");
		g[3] = readGraph("src/main/java/medium2");
		g[4] = readGraph("src/main/java/medium3");
		g[5] = readGraph("src/main/java/medium4");
		
		// This will view the adjacency list of a graph
		System.out.println(g[0]);
		
		for (int i=0; i<6; i++)
			System.out.println(isEulerian(g[i]));

	}
	
	private static boolean isEulerian(Graph graph) {

		//To make it easier I will not submit my graph class I just added a getlist method that returns the adjacency
		//As expected below
		//public HashMap<String, ArrayList<String>> getList(){
		//		return list;
		//	}

		Set<String> visited = new HashSet<>();
		//Check that all nodes are reachable from a starting node
		String beginning = graph.getList().keySet().iterator().next();

		dfs(beginning,visited,graph);

		if (visited.size() != graph.getList().keySet().size()){
			return false;
		}
		//Check that the degree of the file is even
		int odd = 0;
		for(String node : graph.getList().keySet()){
			if (graph.degree(node) % 2 != 0){
				odd++;
			}
		}
		System.out.println("Graph adjacency list:\n" + graph);
		System.out.println("Visited nodes after DFS: " + visited);
		System.out.println("Odd degree node count: " + odd);

		//Check that exactly two nodes have an odd degree
		if (odd == 0){
			return true;
		} else if (odd == 2) {
			return true;
		} else {
			return false;
		}
	}

	private static void dfs(String node, Set<String> visited, Graph graph) {
		visited.add(node);
		for (String neighbor : graph.getNbrs(node)) {
			if (!visited.contains(neighbor)) {
				dfs(neighbor, visited, graph);
			}
		}
	}
	/**
	 * This function reads a list of edges from a given filename
	 * and returns a simple Graph.
	 * DO NOT EDIT THIS METHOD.
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Graph readGraph(String filename) throws FileNotFoundException {

		FileReader f = new FileReader(filename);
		Scanner sc = new Scanner(f);

		Graph g = new Graph();
		while (sc.hasNext()) {
			String u = sc.next();
			String v = sc.next();
			g.add(u);
			g.add(v);
			g.add(u,v);
		}
		sc.close();
		return g;
	}
}
