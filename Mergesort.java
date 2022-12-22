import java.util.*;
import java.io.*;
public class Mergesort {
    static int a[];
    static void mergesort(int [] a){
        if(a.length == 1) return;
        int [] left = new int [a.length/2], right = new int [a.length-a.length/2];
        int i = 0;
        for(; i < left.length; i++){
            left[i] = a[i];
        }
        for(; i < a.length; i++){
            right[i-left.length] = a[i];
        }
        mergesort(left); mergesort(right);
        int lcnt = 0, rcnt = 0;
        for(i = 0; i < a.length; i++){
            if(lcnt == left.length){
                a[i] = right[rcnt++];
            }
            else if(rcnt == right.length){
                a[i] = left[lcnt++];
            }
            else if(left[lcnt] < right[rcnt]){
                a[i] = left[lcnt++];
            }
            else a[i] = right[rcnt++];
        }
    }
    public static void main(String[] args) throws IOException{
        System.out.print("Enter the amount of numbers: ");
        int n = readInt();
        a = new int [n];
        System.out.print("Enter the array: ");
        for(int i = 0; i < n; i++){
            a[i] = readInt();
        }
        mergesort(a);
        System.out.print("The sorted array is: ");
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
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
