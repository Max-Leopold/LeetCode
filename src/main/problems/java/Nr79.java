package main.problems.java;

public class Nr79 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    if (check(board, word, 0, row, column)) return true;
                }
            }

            return false;
        }

        public boolean check(char[][] board, String word, int word_idx, int row, int column) {
            if (word_idx >= word.length()) return true;
            if (row < 0 || row >= board.length) return false;
            if (column < 0 || column >= board[row].length) return false;
            if (word.charAt(word_idx) != board[row][column]) return false;

            board[row][column] = ' ';
            boolean works = check(board, word, word_idx + 1, row + 1, column) ||
                    check(board, word, word_idx + 1, row - 1, column) ||
                    check(board, word, word_idx + 1, row, column + 1) ||
                    check(board, word, word_idx + 1, row, column - 1);
            board[row][column] = word.charAt(word_idx);

            return works;
        }
    }
}
