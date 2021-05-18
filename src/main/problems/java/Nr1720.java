package main.problems.java;

public class Nr1720 {
    public int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;
        for (int i = 1; i < decoded.length; i++) {
            decoded[i] = encoded[i - 1] ^ decoded[i - 1];
        }
        return decoded;
    }
}
