import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class HashingWords {

	//QUESTION 1 Answer is agarwal and hazardless
	//QUESTION 2 Answer is 14
	//Question 3 None

	public static void main(String[] args) throws IOException {
		FileReader f = new FileReader("src/main/java/englishWords.txt");
		Scanner sc = new Scanner(f);
		ArrayList<String> duplicateWords = new ArrayList<>();
		Hashtable<Integer,String> pairs = new Hashtable<>();
		//getting everything into the hashtable and storing duplicates in duplicateWords arraylist
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (pairs.containsKey(s.hashCode())){
				duplicateWords.add(s);
			}
			pairs.putIfAbsent(s.hashCode(),s);
		}


		System.out.println(pairs);
		System.out.println("================================================================");

		//Checking which duplicates go with which words in the original dictionary
		for (String string: duplicateWords){
			if(pairs.containsKey(string.hashCode())){
				System.out.println(pairs.get(string.hashCode()) + " = " + string + " = " + string.hashCode());
			}
		}
		System.out.println("=============");
		System.out.println(duplicateWords.size());
		sc.close();
	}

}