import java.util.*;
import java.io.*;

public class LongestCommonSubsequence{
    public static void main(String[] args) throws IOException{
        System.out.print("Enter a string: ");
        String a = next();
        System.out.print("Enter a string: ");
        String b = next();
        int n = a.length(), m = b.length();
        int dp [][] = new int [n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println("The length of the longest common subsequence is: " + dp[n][m]);
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