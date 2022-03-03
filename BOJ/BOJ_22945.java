import java.io.*;
import java.util.*;

public class BOJ_22945 {
    static int N;
    static int[] X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0, e = N - 1;
        int answer = 0;
        while (s < e) {
            answer = Math.max(answer, Math.min(X[s], X[e]) * (e - s - 1));
            if (X[s] < X[e]) s++;
            else e--;
        }
        System.out.println(answer);
    }
}
