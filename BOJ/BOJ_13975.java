import java.io.*;
import java.util.*;

public class BOJ_13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0, value; i < N; i++) {
                value = Integer.parseInt(st.nextToken());
                pq.add(0L + value);
            }
            long sum = 0;
            for (int i = 0; i < N - 1; i++) {
                long first = pq.poll();
                long second = pq.poll();
                pq.add(first + second);
                sum += first + second;
            }
            System.out.println(sum);
        }
    }
}
