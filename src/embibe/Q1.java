package embibe;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) throws IOException {

		String[] s = getMovieTitles("spiderman");
		System.out.println(s.toString());

	}

	static String[] getMovieTitles(String substr) throws IOException {
		List<String> titles = new ArrayList<>();
		int currPage = 0;
		int totalPage = 1;
		do {
			currPage++;
			String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + currPage;
			URLConnection connection = new URL(url).openConnection();
			InputStream response = connection.getInputStream();

			try (Scanner scanner = new Scanner(response)) {
				String responseBody = scanner.useDelimiter("\\A").next();
				currPage = getNumber(responseBody, "page");
				totalPage = getNumber(responseBody, "total_pages");
				titles.addAll(parse(responseBody));
			}
		} while (currPage != totalPage);
		Collections.sort(titles);
		return titles.toArray(new String[0]);

	}

	private static List<String> parse(String responseBody) {
		List<String> titles = new ArrayList<>();
		int lkaf = 0;
		while (responseBody.indexOf("Title", lkaf) != -1) {
			lkaf = responseBody.indexOf("Title", lkaf) + 2;
			int last = responseBody.indexOf("Year", lkaf);
			titles.add(responseBody.substring(lkaf + 6, last-3));
		}

		return titles;
	}

	private static int getNumber(String responseBody, String s) {
		int ind = responseBody.indexOf(s);
		int last = responseBody.indexOf(',', ind);
		int p = 0;
		if (s.equalsIgnoreCase("page"))
			p = Integer.valueOf(responseBody.substring(ind + s.length() + 3, last - 1));
		else
			p = Integer.valueOf(responseBody.substring(ind + s.length() + 2, last));
		return p;
	}
}
