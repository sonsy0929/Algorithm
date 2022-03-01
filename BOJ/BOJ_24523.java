import java.io.*;
import java.util.*;

public class BOJ_24523 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stk = new Stack<>();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stk.push(Integer.parseInt(st.nextToken()));
        }
        int[] answer = new int[N];
        int pos = N - 1;
        int idx = -1;
        while (!stk.empty()) {
            int tp = stk.peek();
            while (!stk.empty() && tp == stk.peek()) {
                stk.pop();
                answer[pos--] = idx;
            }
            idx = stk.size() + 1;
        }
        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
