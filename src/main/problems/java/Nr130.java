package main.problems.java;

public class Nr130 {
    public void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            flip(board, 0, i, 'P', 'O');
            flip(board, board.length - 1, i, 'P', 'O');
        }
        for (int i = 0; i < board.length; i++) {
            flip(board, i, 0, 'P', 'O');
            flip(board, i, board[0].length - 1, 'P', 'O');
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'P') board[i][j] = 'O';
            }
        }
    }

    public void flip(char[][] board, int row, int column, char to, char from) {
        if (row >= board.length || row < 0) {
            return;
        }
        if (column >= board[0].length || column < 0) {
            return;
        }
        if (board[row][column] == from) {
            board[row][column] = to;
        } else {
            return;
        }
        flip(board, row + 1, column, to, from);
        flip(board, row - 1, column, to, from);
        flip(board, row, column + 1, to, from);
        flip(board, row, column - 1, to, from);
    }
}
