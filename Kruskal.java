import java.util.*;
import java.io.*;
public class Kruskal {
    static int p [];
    static int find(int x){
        if(p[x] != x) return p[x] = find(p[x]);
        return p[x];
    }
    static void kruskal() throws IOException{
        System.out.print("Enter the amount of nodes: ");
        int n = readInt(); 
        System.out.print("Enter the number of edges: ");
        int m = readInt();
        p = new int [n+1];
        ArrayList <edge> edges = new ArrayList();
        for(int i = 1; i <= n; i++) p[i] = i;
        for(int i = 0; i < m; i++){
            System.out.println("Enter a weighted edge: ");
            int u = readInt(), v = readInt(), w = readInt();
            edges.add(new edge(u, v, w));
        }
        Collections.sort(edges);
        int ans = 0;
        for(edge e : edges){
            int u = e.u, v = e.v, w = e.w;
            int x = find(u), y = find(v);
            if(x != y){
                p [y] = p[x];
                ans += w;
            }
        }
        for(int i = 2; i <= n; i++){
            if(find(1) != find(i)){
                System.out.println("The graph is not connected");
                return;
            }
        }
        System.out.println("The minimum spanning tree is: " + ans);
    }
    public static void main(String[] args) throws IOException{
        kruskal();
    }
    static class edge implements Comparable<edge>{
        int u, v, w;
        edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int compareTo(edge e){
            return Integer.compare(w, e.w);
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
