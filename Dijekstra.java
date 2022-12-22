import java.util.*;
import java.io.*;
public class Dijekstra {
    static List<pair> adj [];
    static int dist[];
    static void dijekstra() throws IOException{
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
        
        PriorityQueue <pair> pq = new PriorityQueue();
        pq.add(new pair(src, 0)); dist[src] = 0;
        while(!pq.isEmpty()){
            int u = pq.peek().v, d = pq.poll().w;
            if(d != dist[u]) continue;
            for(pair p : adj[u]){
                int v = p.v, w = p.w;
                if(dist[v] > dist[u] + w){
                    dist[v] = dist[u] + w;
                    pq.add(new pair(v, dist[v]));
                }
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.println("From " + src + " to " + i + " minimum distance is: " + dist[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        dijekstra();
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
