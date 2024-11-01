import java.util.ArrayList;

/*Question 2 BUCKETSORT ANSWER:

*/

public class BucketSortMain {

	public static void main(String[] args) {

		int N = 1_000_000;    // You can decrease this to test your ideas out
		int numBuckets = 100; // Can increasing this number speed it up?
		int maxNum = 10_000;  // numbers from 0 to 10,000 only. You can leave this alone.
		
		BucketList<String> b = new BucketList<String>(0, maxNum, numBuckets);

		ArrayList<Entry<String>> allEntries = new ArrayList<Entry<String>>();
		
		System.out.println("Phase 1: Creating Entries");
		for (int i=1; i <= N; i++) {
			Entry<String> e = new Entry<String>((int)(Math.random()*maxNum),null); // null Strings to avoid instantiating more Strings
			allEntries.add(e);
		}
		System.out.println("Done creating list");

		
		System.out.println("Phase 2: Adding to buckets");
		b.addAll(allEntries);		
		System.out.println("Done adding to buckets");
//		System.out.println(b);
		
		
		System.out.println("Phase 3: Extracting sorted order as a list");
		ArrayList<Entry<String>> sorted = b.getSortedOrder();
		System.out.println("done");
//		System.out.println(sorted);
	}

}
