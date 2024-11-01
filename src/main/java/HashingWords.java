import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HashingWords {


	public static void main(String[] args) throws IOException {
		FileReader f = new FileReader("englishWords.txt");
		Scanner sc = new Scanner(f);
		ArrayList<String> words = new ArrayList<>();


		while (sc.hasNext()) {
			String s = sc.nextLine();
			words.add(s);
		}
		
		sc.close();
	}

}