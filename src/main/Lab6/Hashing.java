//Dante Bertolutti - 300253505

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Hashing {

	// with ~341,000 words, a table size of 1mil keeps the load factor low
	static final int tableSize = 1_000_000;

	public static void main(String[] args) throws IOException {

		// Done: You will be hashing strings using polynomial in k, for all values
		// k=1 to 50. Once you have this one case (of k=31) working, you will
		// probably want to wrap your code in a for loop for k=1 to 50
		// Leave these two lines alone for opening the input file
		FileReader f = new FileReader("src/main/Lab6/englishWords.txt");
		Scanner sc = new Scanner(f);


		for (int k = 1; k <= 50; k++) {
			// This creates your hashtable or simulated hashtable of size tableSize
			int[] counts = new int[tableSize];
			int collisions = 0;
			int maxbucket = 0;
			// This loop runs through the words in the file
			while (sc.hasNext()) {
				String s = sc.nextLine();
				// Done: remove or comment-out this next line, or modify it
				// for your own debugging purposes
				// Done: Find hashValue of s using hash(s,k). Update your simulated hashtable
				// note: if your hash(s,k) function is correct, hash(s,31) should
				//			correspond exactly to s.hashCode();
				int hashValue = hash(s,k);
				counts[hashValue]++;
				// Done: Don't forget to count collisions
				if(counts[hashValue] > 1){
					collisions++;
				}
				// Done: Find the maximum bucket size
				if(counts[hashValue] > maxbucket) {
					maxbucket = counts[hashValue];
				}
			}


			// Done: Report the total number of collisions found at this k value
			System.out.println("Total Collisions: " + collisions);
			// Done: Report the maximum bucket size found at this k value
			System.out.println("Maximum Bucket Size: " + maxbucket);

			//Was getting 0 for all the collisions and max bucket sizes after the first k instance
			sc = new Scanner(new FileReader("src/main/Lab6/englishWords.txt"));
			// Leave this line alone to close the input file
			f.close();
		}
	}

	public static int hash(String s, int k) {
		int value = 0;
		int n = s.length();
		// Done: Compute the hash function in O(n) time, where n = s.length()
		// You can do this using Horner's method to compute the polynomial
		// s[0]*k^(n-1) + s[1]*k^(n-2) + ... + s[n-1]
		for (int i = 0; i < n; i++){
			value = value * k + s.charAt(i);
			//This line is a method I found for handling negatives in a hashtable
			//It the method basically guarantees a non-negative value and works essentially how you described in the lab document
			value = (value % tableSize + tableSize) % tableSize;
		}


		return value;
	}
}

/***********************************************************
 * Report your best k values here in this comment block
 * (if you want, you can output all k values and then visually
 * inspect your output for your 3 best k values). Give your 3
 * best k-values for (i) the smallest total number of collisions,
 * and also give another set of (ii) your 3 best k-values according
 * to the smallest value for the max-bucket-size.
 *  Smallest Number of collisions = 33, 41, 23
 *  Smallest Max Bucket Size = 29, 33, 41
 */