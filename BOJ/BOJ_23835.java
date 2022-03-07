import java.io.*;
import java.util.*;

class Pair {
    int first, second;
    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

public class BOJ_23835 {
    static int N, Q;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static LinkedList<Pair> used, tracings;
    static int[] counts;
    static void dfs(int curr, int dest, int parent, int order) {
        if (curr == dest) {
            for (Pair pair : used) {
                tracings.add(pair);
            }
            return;
        }
        for (int next : adj.get(curr)) {
            if (next == parent) continue;
            used.add(new Pair(next, order));
            dfs(next, dest, curr, order + 1);
            used.pollLast();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        counts = new int[N];
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0, u, v; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj.get(u-1).add(v-1);
            adj.get(v-1).add(u-1);
        }
        used = new LinkedList<>();
        tracings = new LinkedList<>();
        Q = Integer.parseInt(br.readLine());
        for (int i = 0, t, u, v; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            if (t == 1) {
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                tracings.clear();
                dfs(u-1, v-1, -1, 1);
                for (Pair pair : tracings) {
                    int curr = pair.first;
                    int order = pair.second;
                    counts[curr] += order;
                }
            }
            else {
                u = Integer.parseInt(st.nextToken());
                System.out.println(counts[u-1]);
            }
        }
    }
}
