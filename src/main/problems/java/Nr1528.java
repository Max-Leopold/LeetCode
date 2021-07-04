package main.problems.java;

import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class Nr1528 {

    public String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }

    // Just playing around with the stream API
    public String restoreStringStream(String s, int[] indices) {
        return IntStream.range(0, s.length() - 1)
                .boxed()
                .sorted(Comparator.comparingInt(o -> indices[o]))
                .map(s::charAt)
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString
                ));

    }
}
