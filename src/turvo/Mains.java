package turvo;
import java.io.*;
import java.util.*;


public class Mains {
    public static void main(String[] args)  {

       
      
            long out_ = number_creation(1, 4, 5);
            System.out.println(out_);
         
    }
    public static long findenergy(int n, int m,int c,int a,int b){
    long c1=0,c2=0,c3=0,cmin=0;
        if(n<=0)
        return 0;
        if(n==m)
        return c;
        
        if(n<m){
            if(n+1==m){
                return (c+a);
            }
            else if(2*n==m)
            return (c+b);
            
            else {
                c1=findenergy(n+1,m,c+a,a,b);
                c2=findenergy(2*n,m,c+b,a,b);
               // if(c1==0)
                //return c2;
                //else if(c2==0)
                //return c1;
                //else {
                    cmin= Math.min(c1,c2);
                //}
            }
            
        }
        
        else if(n>m){
            if(n-1==m)
            return (c+a);
            else{
                c3= findenergy(n-1,m,c+a,a,b);
            }
        }
        if(c3==0)
        return cmin;
        
        return (Math.min(cmin,c3));
    }
    static long number_creation(int A, int X, int B){
        long cost = findenergy(1,X,A,A,B);
        
    return cost;
    }
}