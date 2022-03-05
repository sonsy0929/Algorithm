import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_24230 {
    static int N;
    static int count;
    static int[] wantColors;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static void dfs(int curr, int parent, int paint) {
        if (paint != wantColors[curr]) count++;
        for (int next : adj.get(curr)) {
            if (next != parent) dfs(next, curr, wantColors[curr]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        wantColors = new int[N];
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
            wantColors[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0, u, v; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            u--; v--;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(0, -1, 0);
        System.out.println(count);
    }
}
