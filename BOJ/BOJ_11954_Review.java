import java.io.*;
import java.util.*;
import java.util.function.Supplier;

public class Review {
    static LinkedList<String> outputs = new LinkedList<>();
    static int brace = 0;
    static StringBuilder word = new StringBuilder();
    static Factory factory = new Factory();

    static class Factory {
        private final static Map<Character, Supplier<Strategy>> map = new HashMap<>();

        static {
            map.put('{', openBraceStrategy::new);
            map.put('}', closeBraceStrategy::new);
            map.put(',', commaStrategy::new);
        }

        public Strategy getStrategy(Character c) {
            Supplier<Strategy> function = map.getOrDefault(c, otherStrategy::new);
            return function.get();
        }
    }

    interface Strategy {
        void process(char c);
    }

    static class openBraceStrategy implements Strategy {
        public openBraceStrategy() {}

        @Override
        public void process(char c) {
            String output = "";
            output = " ".repeat(brace++ * 2) + "{";
            outputs.add(output);
        }
    }

    static class closeBraceStrategy implements Strategy {
        public closeBraceStrategy() {}

        @Override
        public void process(char c) {
            if (word.length() > 0) {
                String output = " ".repeat(brace * 2) + word;
                word = new StringBuilder();
                outputs.add(output);
            }
            String output = " ".repeat(--brace * 2) + "}";
            outputs.add(output);
        }
    }

    static class commaStrategy implements Strategy {
        public commaStrategy() {}

        @Override
        public void process(char c) {
            String output;
            if (word.length() == 0) {
                output = outputs.pollLast();
                output += ",";
            }
            else {
                output = " ".repeat(brace * 2) + word + ",";
                word = new StringBuilder();
            }
            outputs.addLast(output);
        }
    }

    static class otherStrategy implements Strategy {
        public otherStrategy() {}

        @Override
        public void process(char c) {
            word.append(c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (char c : input.toCharArray()) {
            Strategy strategy = factory.getStrategy(c);
            strategy.process(c);
        }
        for (String output : outputs) {
            System.out.println(output);
        }
    }
}
