import java.io.*;
import java.util.*;

public class BOJ_11003 {
    static int N, L;
    static int[] A;
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getFirst() <= i - L) deque.pollFirst();
            while (!deque.isEmpty() && A[deque.getLast()] > A[i]) deque.pollLast();
            deque.addLast(i);
            bw.write(A[deque.getFirst()] + " ");
        }
        bw.flush();
        bw.close();
    }
}
