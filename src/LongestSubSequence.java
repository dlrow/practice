import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class LongestSubSequence {

	public static void main(String[] args) throws FileNotFoundException {
		// LongestSubSequence l=new LongestSubSequence();
		LongestSubSequence.writeToFile();
		LongestSubSequence.ReadFromFile();

	}

	public static void writeToFile() {

		try (FileOutputStream f = new FileOutputStream("TextFile.txt")) {
			String s = "abcdefghijklmnopqrstuvwxyz";
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= 3000; i++) {
				int index = (int) (s.length() * Math.random());
				sb.append(s.charAt(index));

			}
			String randomText = sb.toString();
			f.write(randomText.getBytes());
			System.gc();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("written success");
	}

	public static void ReadFromFile() {
		StringBuilder sb1 = new StringBuilder();
		try (FileInputStream fileInputStream = new FileInputStream("TextFile.txt")) {

			int data = fileInputStream.read();
			while (data != -1) {
				sb1.append((char) data);
				data = fileInputStream.read();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String s1 = sb1.toString();
		String sub;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			for (int j = i+1; j <= s1.length() - i; j++) {
				sub = s1.substring(i, i + j);
				// System.out.println("substring is "+sub);
				if (!map.containsKey(sub)) {
					map.put(sub, 1);
				}

				else {
					map.put(sub, map.get(sub) + 1);
				}

			}

		}
		System.out.println(map);

	}

}