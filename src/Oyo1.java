import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Oyo1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<String> products = new ArrayList<>();
		products.add("rice");
		products.add("sug");
		products.add("wheat");
		List<String> productSold = new ArrayList<>();
		productSold.add("rice");
		productSold.add("wheat");
		List<Float> productPrices = new ArrayList<>();
		productPrices.add(3.25f);
		productPrices.add(4.25f);
		productPrices.add(5.25f);
		List<Float> soldPrice = new ArrayList<>();
		soldPrice.add(3.25f);
		soldPrice.add(4.25f);
		System.out.println(priceCheck(products, productPrices, productSold, soldPrice));
		
	
	}
	
	public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
		int ans=0;
        Map<String, Float> origPrice  =new HashMap<>();
        Map<String, Float> sellPrice  =new HashMap<>();
        for(int i=0;i<products.size();i++) {
        	origPrice.put(products.get(i), productPrices.get(i));
        }
        
        for(int i=0;i<soldPrice.size();i++) {
        	sellPrice.put(productSold.get(i), soldPrice.get(i));
        }
        for(Map.Entry<String,Float> entry : sellPrice.entrySet()) {
        	if( origPrice.get(entry.getKey()).equals(sellPrice.get(entry.getKey())))
        			ans++;
        }
        return ans;
    }

}
