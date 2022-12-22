import java.util.*;
import java.io.*;
public class QuickPower {
    static long qpow(int b, int x){
        if(x == 0) return 1;
        long a = qpow(b, x/2);
        a*=a;
        if((x&1) == 1) a*=b;
        return a;
    }
    public static void main(String[] args) throws IOException{
        System.out.print("Enter the base: ");
        int b = readInt();
        System.out.print("Enter the exponent: ");
        int x = readInt();
        System.out.println(b + "^" + x + " = " + qpow(b, x));
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
