// Java program to find positional elements in 
// a matrix. 
import java.util.ArrayList;

public class Factor {
    
    public static void factor( int n,int start, ArrayList<Integer> arr ){
        
        if(n==1){
            System.out.println("n=1"+arr);
            for(int i=0;i<arr.size();i++)
            	arr.remove(i);
            //arr= new ArrayList<Integer>();
           
        }
        
        else{
            for(int i=start; i<=n;i++){
                if(n%i==0){
                    arr.add(i);
                    factor(n/i,i,arr);
                   // System.out.println("n="+n+" "+arr.toString());
                }
            }
            
        }
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        factor(6, 2,new ArrayList<Integer>());
    }

}
