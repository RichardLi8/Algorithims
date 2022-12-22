import java.util.*;
import java.io.*;
public class SPFA {
    static List<pair> adj [];
    static boolean inqueue[];
    static int dist[];
    static void spfa() throws IOException{
        System.out.print("Enter the amount of nodes: ");
        int n = readInt(); 
        System.out.print("Enter the number of edges: ");
        int m = readInt();
        adj = new ArrayList[n+1];
        dist = new int[n+1];
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList();
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < m; i++){
            System.out.print("Enter a weighted edge: ");
            int u = readInt(), v = readInt(), w = readInt();
            adj[u].add(new pair(v, w));
            adj[v].add(new pair(u, w));
        }
        System.out.print("Enter the source node: ");
        int src = readInt();
        
        inqueue = new boolean [n+1];
        Queue <Integer> q = new LinkedList();
        q.add(src); inqueue[src] = true; dist [src] = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            inqueue[u] = false;
            for(pair p : adj[u]){
                int v = p.v, w = p.w;
                if(dist[v] > dist[u] + w){
                    dist[v] = dist[u] + w;
                    if(!inqueue[v]){
                        q.add(v);
                        inqueue[v] = true;
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.println("From " + src + " to " + i + " minimum distance is: " + dist[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        spfa();
    }
    static class pair{
        int v, w;
        pair(int v, int w){
            this.v = v;
            this.w = w;
        }
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
