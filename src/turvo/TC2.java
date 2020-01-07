package turvo;

import java.io.*;
import java.util.*;


public class TC2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] temp = br.readLine().split(" ");
            int X = Integer.parseInt(temp[0]);
            int A = Integer.parseInt(temp[1]);
            int B = Integer.parseInt(temp[2]);
            R=new long[100000];
            
            long out_ = number_creation(A, X, B);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static long R[];
    static long number_creation(int A, int X, int B){
		if(X==1)
			return A;
		if(R[X]!=0)
			return R[X];
		if(X%2==1 ) {
			R[X]=A+number_creation(A,X-1,B);
		}
		else {
			R[X]=Math.min(A+number_creation(A,X-1,B), B+number_creation(A,X/2,B));
		}
    	
    	return R[X];
       
    }
    
    
}