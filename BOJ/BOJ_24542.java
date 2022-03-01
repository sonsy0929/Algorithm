import java.io.*;
import java.util.*;

public class BOJ_24542 {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int N, M;
    static int MOD = (int)1e9 + 7;
    static boolean[] visited;
    static int dfs(int curr) {
        int count = 1;
        visited[curr] = true;
        for (int next : adj.get(curr)) {
            if (visited[next]) continue;
            count += dfs(next);
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            u--; v--;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        long answer = 1;
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            answer *= dfs(i);
            answer %= MOD;
        }
        System.out.println(answer);
    }
}
