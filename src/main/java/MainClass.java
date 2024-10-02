import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {

		// No modifications are needed in this main method. It is
		// here just to illustrate a typical usage of this BucketList
		// object and the resulting BucketSort method

		// This example makes a list of 6 buckets.
		// Key values are grades, so range is: min=0 max=100
		// It adds the 6 objects from the test file, plus
		// several randomly-generated students.
		
		// This file, as given, will have no errors or warnings
		// if the BucketList and SortedBucket classes are fully
		// implemented
		
		// Feel free to tinker with this file as you are developing.

		BucketList<String> b = new BucketList<String>(0,100,6);
		b.add(new Entry<String>(94 , "Jim"));
		System.out.println(b);
		b.add(new Entry<String>(93 , "Val"));
		System.out.println(b);
		b.add(new Entry<String>(68 , "C-Student"));
		System.out.println(b);
		b.add(new Entry<String>(72 , "B-Student"));
		System.out.println(b);
		b.add(new Entry<String>(84 , "A-Student"));
		System.out.println(b);
		b.add(new Entry<String>(98 , "A-plus-Student"));
		System.out.println(b);

		// add N more random students
		int N = 10;
		ArrayList<Entry<String>> allStudents = new ArrayList<Entry<String>>();
		for (int i=1; i<=N; i++) {
			Entry<String> e = new Entry<String>((int)(45+Math.random()*50),"stu"+i);
			allStudents.add(e);
		}

		// add the whole class to the buckets
		b.addAll(allStudents);
		
		// display all buckets and their contents
		System.out.println(b);
		
		// display the final sorted order
		ArrayList<Entry<String>> sorted = b.getSortedOrder();
		System.out.println(sorted);
	}

}
