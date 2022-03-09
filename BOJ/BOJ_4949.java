import java.io.*;
import java.util.*;

public class BOJ_4949 {
    public static boolean isOpen(char c) {
        return c == '(' || c == '[';
    }
    public static boolean isClose(char c) {
        return c == ')' || c == ']';
    }
    public static boolean isOk(String s) {
        return s.equals("()") || s.equals("[]");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String string = br.readLine();
            if (string.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            boolean balanced = true;
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (isOpen(c) == true) {
                    stack.push(c);
                }
                if (isClose(c) == true) {
                    if (stack.empty() || !isOk(stack.peek() + "" + c)) {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (balanced && stack.empty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
