import java.util.*;
import java.io.*;
public class TopologicalSort {
    static void topo() throws IOException{
        System.out.print("Enter the amount of nodes: ");
        int n = readInt();
        System.out.print("Enter the number of edges: ");
        int m = readInt();
        int [] deg = new int [n+1];
        List <Integer> adj [] = new ArrayList [n+1];
        for(int i = 1; i <= n; i++) adj[i] = new ArrayList();
        for(int i = 0; i < m; i++){
            System.out.println("Enter the directed edge: ");
            int u = readInt(), v = readInt();
            adj[u].add(v);
            deg[v]++;
        }
        Queue <Integer> q = new LinkedList();
        for(int i = 1; i <= n; i++){
            if(deg[i] == 0){
                q.add(i);
            }
        }
        System.out.print("The topological order of the graph is: ");
        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj[u]){
                if(--deg[v] == 0){
                    q.add(v);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        topo();
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
