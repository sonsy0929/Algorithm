import java.io.*;
import java.util.*;

public class BOJ_24396 {
    static int N, M;
    static int[] dists;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static HashSet<String> set = new HashSet<String>();
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0, u, v; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            u--; v--;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    static void bfs() {
        int[] counts = new int[N];
        dists = new int[N];
        Arrays.fill(dists, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        dists[0] = 0;
        int dist = 1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            Arrays.fill(counts, 0);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : adj.get(curr)) {
                    counts[next]++;
                }
            }
            for (int i = 0; i < N; i++) {
                if (dists[i] == -1 && counts[i] < qSize) {
                    queue.add(i);
                    dists[i] = dist;
                }
            }
            dist++;
        }
    }
    static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(dists[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        input();
        bfs();
        print();
    }
}
