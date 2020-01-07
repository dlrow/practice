package ccFeb;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			String s1 = in.next();
			String s2 = in.next();

			System.out.println(findParkingPrice(s1, s2));

		}
	}

	static int findParkingPrice(String entryTime, String leavingTime) {
		int totalcost = 2;

		if (isEntryPlusOneLessThanLeaving(entryTime, leavingTime)) {
			totalcost += 3;
		}
		entryTime = getEntryPlusOne(entryTime);
		while (isEntryPlusOneLessThanLeaving(entryTime, leavingTime)) {
			totalcost += 4;
			entryTime = getEntryPlusOne(entryTime);
		}
		return totalcost;

	}

	private static String getEntryPlusOne(String entryTime) {
		StringBuilder sb = new StringBuilder(entryTime);
		Integer i = Integer.valueOf(sb.substring(0, 2));
		i += 1;
		String hrs=String.valueOf(i);
		if(hrs.length()<2)
			hrs='0'+hrs;
		sb = sb.replace(0, 2,hrs );
		return sb.toString();
	}

	private static boolean isEntryPlusOneLessThanLeaving(String entryTime, String leavingTime) {
		Integer enthrs = Integer.valueOf(entryTime.substring(0, 2));
		Integer leavhrs = Integer.valueOf(leavingTime.substring(0, 2));
		if (enthrs < leavhrs)
			return true;
		if(enthrs>leavhrs)
			return false;
		
		Integer entmin = Integer.valueOf(entryTime.substring(3, 5));
		Integer leavmin = Integer.valueOf(leavingTime.substring(3, 5));
		if (entmin < leavmin)
			return true;
		return false;

	}

}
