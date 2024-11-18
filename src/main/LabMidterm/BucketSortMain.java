import java.util.ArrayList;

/*Question 2 BUCKETSORT ANSWER:
	Sarah is correct for a few reasons the first being that creating more buckets is a much easier process than searching through larger buckets on every pass through the algorithm
	the second is that by having more buckets the algorithm has an easier time allocating a bucket as it does not have to check nearly as many elements per bucket. The buckets are sorted individually
	and if you have to spend significantly longer sorting each bucket making a new one becomes much more simple and faster.
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
