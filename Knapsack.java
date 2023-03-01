import java.util.*;
import java.io.*;

public class Knapsack{
    public static void main(String[] args) throws IOException{
        System.out.print("Enter the capacity: ");
        int size = readInt();
        System.out.print("Enter the number of items: ");
        int n = readInt();
        int dp [] = new int[size+1];
        for(int i = 0; i < n; i++){
            System.out.print("Enter the cost and value: ");
            int c = readInt(), v = readInt();
            for(int j = size; j >= c; j--){
                dp[j] = Math.max(dp[j], dp[j-c] + v);
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