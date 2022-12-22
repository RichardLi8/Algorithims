import java.util.*;
import java.io.*;
public class DFS {
    static List<Integer> adj [];
    static boolean vis[];
    static void dfs(int src){
        vis[src] = true;
        System.out.print(src + " --> ");
        for(int v : adj[src]){
            if(!vis[v]){
                dfs(v);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.print("Enter the amount of nodes: ");
        int n = readInt(); 
        System.out.print("Enter the number of edges: ");
        int m = readInt();
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) adj[i] = new ArrayList();
        vis = new boolean [n+1];
        for(int i = 0; i < m; i++){
            System.out.print("Enter an edge: ");
            int u = readInt(), v = readInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        System.out.print("Enter the source node: ");
        int src = readInt();
        dfs(src);
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
