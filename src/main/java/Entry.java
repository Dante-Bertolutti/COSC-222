import java.util.Objects;

/**
 * A (key,value) pair class. Key is int type. 
 * 
 * @author cosc222
 *
 * @param <V>
 */
public class Entry <V> {
	private int key;
	private V val;
	
	public Entry(int k, V v) {
		key = k;
		val = v;
	}

	public int getKey() {
		return this.key;
	}

	public V getValue() {
		return this.val;
	}

	public String toString() {
		return this.getValue()+"="+this.getKey();
	}

	//https://hostman.com/tutorials/overriding-the-equals-method-in-java/ got information from here
	@Override
	public int hashCode(){
		return Objects.hash(key, val);
	}
	@Override
	public boolean equals(Object obj){
		if (obj == this){
			return true;
		}
		Entry<?> e = (Entry<?>) obj;
		return e.val.equals(val) && e.key == key;
	}
}

