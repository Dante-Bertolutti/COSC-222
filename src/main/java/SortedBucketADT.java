import java.util.ArrayList;

/* Don't change this class unless you know what you are doing*/

public interface SortedBucketADT<V>{

	void add(Entry<V> t);

	ArrayList<Entry<V>> getBucketContents();

}
