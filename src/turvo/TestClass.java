package turvo;

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_a = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i_a = 0; i_a < arr_a.length; i_a++) {
            a[i_a] = Integer.parseInt(arr_a[i_a]);
        }

        long out_ = getMagicValue(a);
        wr.println(out_);

        wr.close();
        br.close();
    }

    static long getMagicValue(int[] a) {
       
        int copy[]=a.clone();
        Arrays.sort(a);
        long g=0,bad=0;
        for(int i=0;i<a.length;i++) {
        	if(a[i]==copy[i])
        		g+=copy[i];
        	else
        		bad+=copy[i];
        }
        return g-bad;
    }
}