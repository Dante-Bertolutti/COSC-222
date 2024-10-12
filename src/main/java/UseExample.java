import java.util.ArrayList;

public class UseExample {

	public static void main(String[] args) {
		String[] words = {"z", "z", "z", "word", "so", "many", "words","i",
				"sure", "do", "enjoy", "java", "programming",
				"and", "this", "seems", "to", "be", "enough"};

		ArrayList<String> sorted = heapSort(words);

		System.out.println(sorted);
		/* Should output:
		 * [and, be, do, enjoy, enough, i, java, many, programming, seems, so, sure, this, to, word, words, z, z, z]
		 */
	}

	public static ArrayList<String> heapSort(String[] words) {
		ArrayList<String> output = new ArrayList<String>();
		MinHeap<String> m = new MinHeap<>();

		for (String s:words)
			m.add(s);
		
		while (m.size() > 0) {
			output.add(m.poll());
		}
		return output;
	}

}
