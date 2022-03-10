import java.io.*;
import java.util.*;

public class BOJ_21938 {
    static int N, M, T;
    static int roff[] = {-1, 1, 0, 0};
    static int coff[] = {0, 0, -1, 1};
    static int[][] colors;
    static boolean[][] visited;

    public static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r <= N && c <= M;
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + roff[d], nc = c + coff[d];
            if (!isIn(nr, nc) || visited[nr][nc]) continue;
            if (colors[nr][nc] != 0) dfs(nr, nc);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        colors = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3 * M; j++) {
                sum += Integer.parseInt(st.nextToken());
                if (j % 3 == 0) {
                    colors[i][j / 3] = sum / 3;
                    sum = 0;
                }
            }
        }
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (colors[i][j] >= T) colors[i][j] = 255;
                else colors[i][j] = 0;
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j]) continue;
                if (colors[i][j] != 0) {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}