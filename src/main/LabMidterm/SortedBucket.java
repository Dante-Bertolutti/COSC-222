//Dante Bertolutti - 300253505
//Dante Bertolutti - 300253505
import java.util.ArrayList;

//TODO: 1 "to do" item below

public class SortedBucket<V> implements SortedBucketADT<V>{

	private ArrayList<Entry<V>> b;

	/** 
	 *  Constructor. Instantiates a bucket, which will be a sorted
	 *  collection of Entries (with each Entry being a key,value pair)
	 */
	public SortedBucket() {
		// Don't touch.
		b = new ArrayList<Entry<V>>();
	}

	/** 
	 *  Adds entry t to bucket in proper sorter order
	 */
	@Override
	public void add(Entry<V> t) {
		// TODO: Implement this method
		if (b.isEmpty()){
			b.add(t);
			return;
		}
      	for(int i = 0; i < b.size(); i++){
			  if (t.getKey() < b.get(i).getKey()){
				  b.add(i,t);
				  return;
			  }
		}
		/* HINT: This is the main sorting process. As we insert into a
		 * bucket the Entry t should be placed in the correct position
		 * in the bucket. Lowest keys should be at the 'head' of the list.
		 * That is, index 0 is the smallest key value. The bucket b is
		 * an ArrayList, and you should iterate through the contents of
		 * the bucket until you find where
		 * 			t.getKey() < e.getKey()
		 * and then insert at that position. Note that ArrayList has
		 * an .add(i,t) method which inserts object t into position i
		 * and automatically shifts everything to the right to
		 * make room for t at that position.
		 * 
		 * You will likely need a special case for when you need to insert
		 * into b when b is empty, and another case for when you need
		 * to insert at the end of b
		 * 
		 */
		
		
		b.add(t); // this inserts without considering the order
		return;
	}
	
	
	/**
	 * @return a sorted ArrayList of Entries in this bucket
	 */
	@Override
	public ArrayList<Entry<V>> getBucketContents() {
		// Don't touch.
		return b;
	}

	@Override
	public String toString() {
		// Don't touch.
		return b.toString();
	}
}
