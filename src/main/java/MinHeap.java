//Dante Bertolutti - 300253505

import java.util.Collections;

/**
 * MinHeap of Comparables. Two E objects which extend Comparable can
 * be compared by e1.compareTo(e2), and if this results in a negative
 * value, e1 comes before e2. If it results in a positive value, e2 comes
 * first.
 * This class extends fullBinaryTree, meaning we can use the left and right
 * child functions to get the index of child nodes. But it must also support
 * heap functionality, like up-heap, trickle-down, and extract-min.
 * @param <E>
 */

public class MinHeap<E extends Comparable<E>>
extends FullBinaryTree<E>
implements HeapADT<E> {

	/**
	 * Constructs the underlying ArrayList<E> called 'nodes' 
	 */
	public MinHeap() {
		// Nothing to change here.
		super();
	}

	@Override
	public E poll() {
		//TODO: Get (and remove) the root element. If there are any
		//elements left, extract the last element of nodes and
		//place it into the root position. Then call trickleDown(0) before
		//returning the original root.
		if (nodes.isEmpty()) {
			return null; // Return null if the heap is empty
		}

		E root = nodes.get(0);
		E lastElement = nodes.remove(size() - 1);

		if (!nodes.isEmpty()) {
			nodes.set(0, lastElement);
			trickleDown(0);
		}

		return root;
	}



	private void trickleDown(int i) {
		//TODO: To trickle-down at index i:
		//Determine which of the left or right child is smaller
		//(if they exist at all), then if that child comes
		//before the value at position i, swap them and recurse.

		int leftChildIndex = leftChild(i);
		int rightChildIndex = rightChild(i);
		int smallest = i;

		if (leftChildIndex < size() && nodes.get(leftChildIndex).compareTo(nodes.get(smallest)) < 0) {
			smallest = leftChildIndex;
		}

		if (rightChildIndex < size() && nodes.get(rightChildIndex).compareTo(nodes.get(smallest)) < 0) {
			smallest = rightChildIndex;
		}

		if (smallest != i) {
			Collections.swap(nodes, i, smallest);
			trickleDown(smallest);
		}
	}


	@Override
	public E peek() {
		//TODO: return the root, without removing it
		if (nodes.isEmpty()){
			return null;
		}
		return nodes.getFirst();
	}
	
	@Override
	public void add(E e) {
		//TODO: add an element at the end of nodes, then
		//call upHeap on the last index.
		nodes.add(e);
		upHeap(size() - 1);

	}

	private void upHeap(int index) {
		//TODO: If index==0, you are done. Otherwise, if the element at
		//index comes before its parent, swap it with its parent and then
		//call upHeap on the parent index.
		while(index > 0){
			int parentIndex = parent(index);
			if(nodes.get(index).compareTo(nodes.get(parentIndex)) >= 0){
				break;
			}
			Collections.swap(nodes,index,parentIndex);
			index = parentIndex;
		}

	}
	
	public String toString() {
		// Nothing to change here.
		return nodes.toString();
	}
}
