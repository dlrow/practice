package turvo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0) {
			String line = in.next();
			List<String> words = getWords(line);
			for(int i=words.size()-1;i>=0;i--) {
				System.out.print(words.get(i));
			}
			
		}
	}

	private static List<String> getWords(String line) {
		List<String> words = new LinkedList<>();
		String word = ".";
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i)=='.') {
				words.add(word);
				word=".";
			}
			else
				word=word+line.charAt(i);
		}
		word=word.substring(1);
		words.add(word);
		return words;
	}

}
