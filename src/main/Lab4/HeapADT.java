/**
 * This interface is complete. You do not need to edit this file.
 * You must implement this interface with a MinHeap class.
 * @param <E>
 */
public interface HeapADT<E extends Comparable<E>> {
	
	/**
	 * Add an element to the minHeap
	 * @param e
	 */
	public void add(E e);

	/**
	 * Remove and return the root of the minHeap
	 * @return
	 */
	public E poll();

	/**
	 * Return (and do not remove) the root of the minHeap
	 * @return
	 */
	public E peek();

	
	/**
	 * Return the number of elements in the minHeap
	 * @return
	 */
	public int size();

}
