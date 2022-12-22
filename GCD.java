import java.util.*;
import java.io.*;
public class GCD {
    static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException{
        System.out.print("Enter a number: ");
        int a = readInt();
        System.out.print("Enter a number: ");
        int b = readInt();
        System.out.println("The greatest common divisor is of " + a + " and " + b + " is " + gcd(a, b));
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
