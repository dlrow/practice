package turvo;

public class DateCheck {
	public static void main(String[] args) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date dt = new java.sql.Date(utilDate.getTime());
		System.out.println(dt.getClass());
		System.out.println((java.util.Date)dt);
		Long num = Long.valueOf("123213");
		System.out.println(num);
	
		System.out.println();
	}

}
