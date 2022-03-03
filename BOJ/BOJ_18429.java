import java.io.*;
import java.util.*;

public class BOJ_18429 {
    static int N, K, answer;
    static int[] plusWeights;
    static boolean[] used;
    public static void dfs(int pos, int weight) {
        if (weight < 500) return;
        if (pos == N) answer++;
        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            dfs(pos + 1, weight + plusWeights[i]);
            used[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        plusWeights = new int[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int plusWeight = Integer.parseInt(st.nextToken());
            plusWeights[i] = plusWeight - K;
        }
        dfs(0, 500);
        System.out.println(answer);
    }
}
