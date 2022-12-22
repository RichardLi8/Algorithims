import java.util.*;
import java.io.*;
public class BFS {
    static List<Integer> adj [];
    static boolean vis[];
    static void bfs() throws IOException{
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
        
        vis[src] = true;
        Queue <Integer> q = new LinkedList();
        q.add(src);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj[u]){
                if(!vis[v]){
                    q.add(v);
                    vis[v] = true;
                }
            }
            System.out.print(u + (!q.isEmpty() ? " --> " : "\n"));
        }
    }
    public static void main(String[] args) throws IOException {
        bfs();
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