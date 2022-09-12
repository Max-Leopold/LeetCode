# @param {Integer[][]} matrix
# @return {Void} Do not return anything, modify matrix in-place instead.
def rotate(matrix)
    transpose(mirror(matrix))
end

def mirror(matrix)
    for row_idx in 0...matrix.size / 2
        for col_idx in 0...matrix[row_idx].size
            matrix[row_idx][col_idx], matrix[matrix.size - 1 - row_idx][col_idx] = matrix[matrix.size - 1 - row_idx][col_idx], matrix[row_idx][col_idx]
        end
    end

    matrix
end

def transpose(matrix)
    for row_idx in 0...matrix.size
        for col_idx in row_idx...matrix[row_idx].size
            matrix[row_idx][col_idx], matrix[col_idx][row_idx] = matrix[col_idx][row_idx], matrix[row_idx][col_idx]
        end
    end
    matrix
end