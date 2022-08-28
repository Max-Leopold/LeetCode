# @param {Character[][]} board
# @param {String} word
# @return {Boolean}
def exist(board, word)
    (0...board.size).each do |row|
        (0...board[row].size).each do |column|
            return true if check(board, word, 0, row, column)
        end
    end

    false
end

def check(board, word, word_idx, row, column)
    return true unless word[word_idx]
    return false if row < 0 || row >= board.size
    return false if column < 0 || column >= board[0].size
    return false unless board[row][column] == word[word_idx]

    board[row][column] = nil
    works = check(board, word, word_idx + 1, row + 1, column) ||
    check(board, word, word_idx + 1, row - 1, column) ||
    check(board, word, word_idx + 1, row, column + 1) ||
    check(board, word, word_idx + 1, row, column - 1)
    board[row][column] = word[word_idx]

    works
end