package gs;
import java.util.ArrayList;
import java.util.List;

// Java program to find positional elements in 
// a matrix. 
public class Subsequence { 


	static List<Integer> findTruckCargo(int maxCargoWeight, List<List<Integer>> cargoList) {
	        List<Integer> sol = new ArrayList<>();
	        int kn[][] = new int[cargoList.size()+1][maxCargoWeight+1];
	        int i,w;
	        for(i=0;i<=cargoList.size();i++){
	            for(w=0;w<=maxCargoWeight;w++){
	                if(i==0 || w==0)
	                    kn[i][w]=0;
	                else if(cargoList.get(i-1).get(1)<=w)
	                	kn[i][w] = Math.max(cargoList.get(i-1).get(2)+kn[i-1][w-cargoList.get(i-1).get(1)], 
	                                        kn[i-1][w]);
	                else
	                	kn[i][w] = kn[i-1][w];
	            }
	        }
	        w=maxCargoWeight;
	        int answ=kn[cargoList.size()][maxCargoWeight];
	        /*for(i=cargoList.size();i>0&&answ>0;i--){
	            if(answ==kn[i-1][w])
	                continue;
	            else{
	                sol.add(cargoList.get(i-1).get(0));
	                answ=answ-cargoList.get(i-1).get(2);
	                w=w- cargoList.get(i - 1).get(1);
	            }
	        }*/
	        for(i=1;i<cargoList.size()&&answ>0;i++){
	            if(answ==kn[i-1][w])
	                continue;
	            else{
	                sol.add(cargoList.get(i-1).get(0));
	                answ=answ-cargoList.get(i-1).get(2);
	                w=w- cargoList.get(i - 1).get(1);
	            }
	        }
	        
	        sol.add(kn[cargoList.size()][maxCargoWeight]);
	        return sol;
	    }


public static void main(String[] args) 
{ 
	
	List<List<Integer>> mat = new ArrayList<>();
	List<Integer> row1 = new ArrayList<>();row1.add(38);row1.add(4);row1.add(500);
	List<Integer> row2 = new ArrayList<>();row2.add(21);row2.add(8);row2.add(1800);
	List<Integer> row3 = new ArrayList<>();row3.add(13);row3.add(3);row3.add(1500);
	
	mat.add(row1);mat.add(row2);
	mat.add(row3);
	System.out.println(findTruckCargo(10,mat)); 
} 
} 
