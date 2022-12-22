import java.util.*;
import java.io.*;
public class Prim {
    static List<pair> adj [];
    static int dist[];
    static void prim() throws IOException{
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
        
        PriorityQueue <pair> pq = new PriorityQueue();
        pq.add(new pair(1, 0)); dist[1] = 0;
        while(!pq.isEmpty()){
            int u = pq.peek().v, d = pq.poll().w;
            if(d != dist[u]) continue;
            for(pair p : adj[u]){
                int v = p.v, w = p.w;
                if(dist[v] > w){
                    dist[v] = w;
                    pq.add(new pair(v, dist[v]));
                }
            }
        }
        int mst = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("The graph is not fully connected");
                return;
            }
            mst += dist[i];
        }
        System.out.println("The minimum spanning tree is: " + mst);
    }
    public static void main(String[] args) throws IOException {
        prim();
    }
    static class pair implements Comparable<pair>{
        int v, w;
        pair(int v, int w){
            this.v = v;
            this.w = w;
        }
        public int compareTo(pair p){
            return Integer.compare(w, p.w);
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
