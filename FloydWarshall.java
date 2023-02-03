import java.util.*;
import java.io.*;
public class FloydWarshall {
    static void floyd() throws IOException{
        System.out.print("Enter the amount of nodes: ");
        int n = readInt();
        int [][] adj = new int [n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) adj[i][j] = 0;
                else adj [i][j] = (int)1e9;
            }
        }
        System.out.print("Enter the number of edges: ");
        int m = readInt();
        for(int i = 0; i < m; i++){
            System.out.print("Enter the the weighted edge: ");
            int u = readInt(), v = readInt(), w = readInt();
            adj[u][v] = w;
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
        System.out.print("Enter the number of queries: ");
        int q = readInt();
        for(int i = 0; i < q; i++){
            System.out.print("Enter the src: ");
            int src = readInt();
            System.out.print("Enter the destination: ");
            int dest = readInt();
            if(adj[src][dest] == 1e9){
                System.out.println("Cannot reach " + dest + " from " + src);
            }
            else{
                System.out.println("The distance from " + src + " to " + dest + " is: " + adj[src][dest]);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        floyd();
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
