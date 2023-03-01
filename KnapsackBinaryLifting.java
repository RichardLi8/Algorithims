import java.util.*;
import java.io.*;

public class KnapsackBinaryLifting{
    public static void main(String[] args) throws IOException{
        System.out.print("Enter the capacity: ");
        int size = readInt();
        System.out.print("Enter the number of items: ");
        int n = readInt();
        int dp [] = new int[size+1];
        for(int i = 0; i < n; i++){
            System.out.print("Enter the quantity, cost, and value: ");
            int q = readInt(), c = readInt(), v = readInt();
            for(int k = 1; k <= q; k<<=1){
                for(int j = size; j >= c*k; j--){
                    dp[j] = Math.max(dp[j], dp[j-c*k] + v*k);
                }
                q-=k;
            }
            if(q != 0){
                for(int j = size; j >= c*q; j--){
                    dp[j] = Math.max(dp[j], dp[j-c*q] + v*q);
                }
            }
        }
        System.out.println("The max value is: " + dp[size]);
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException{
        return Integer.parseInt(next());
    }
}