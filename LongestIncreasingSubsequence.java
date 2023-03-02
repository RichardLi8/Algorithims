import java.util.*;
import java.io.*;

public class LongestIncreasingSubsequence{
    static void naive(int a[]){
        int n = a.length;
        int dp [] = new int [n];
        int pre [] = new int[n];
        int max = 0, idx = -1;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(a[i] > a[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    pre[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                idx = i;
            }
        }
        int output [] = new int [max]; 
        for(int i = max-1; i >= 0; i--){
            output[i] = a[idx];
            idx = pre[idx];
        }
        System.out.print("The longest increasing subsequence is: ");
        for(int i = 0; i < max; i++){
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }
    static int binarySearch(int a[]){
        //can't recover sequence with binary search
        int n = a.length;
        var list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            int j = binarySearch(list, a[i]);
            if(j == list.size()) list.add(a[i]);
            else list.set(j, a[i]);
        }
        return list.size();
    }
    static int binarySearch(List<Integer> a, int v){
        int l = 0, r = a.size()-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(a.get(mid) >= v) r = mid-1;
            else l = mid+1;
        }
        return l;
   }
    public static void main(String[] args) throws IOException{
        System.out.print("Enter the amount of numers: ");
        int n = readInt();
        int [] a = new int [n];
        System.out.print("Enter the array: ");
        for(int i = 0; i < n; i++){
            a[i] = readInt();
        }
        System.out.println("The size of the sequence is: " + binarySearch(a));
        naive(a);
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