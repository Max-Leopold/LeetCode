# @param {Integer[][]} matrix
# @return {Void} Do not return anything, modify matrix in-place instead.
def set_zeroes(matrix)
    first_row_zero = false
    first_column_zero = false

    matrix.each_with_index do |row, row_idx|
        row.each_with_index do |val, col_idx|
            if val == 0
                first_column_zero = true if col_idx == 0
                first_row_zero = true if row_idx == 0

                if row_idx > 0 && col_idx > 0
                    matrix[0][col_idx] = 0
                    matrix[row_idx][0] = 0
                end
            end
        end
    end

    (1...matrix.size).each do |row_idx|
        if matrix[row_idx][0] == 0
            nullify_row(matrix, row_idx)
        end
    end

    (1...matrix[0].size).each do |col_idx|
        if matrix[0][col_idx] == 0
            nullify_column(matrix, col_idx)
        end
    end

    nullify_row(matrix, 0) if first_row_zero
    nullify_column(matrix, 0) if first_column_zero
end

def nullify_row(matrix, row_idx)
    matrix[row_idx].map! { |_| 0 }
end

def nullify_column(matrix, col_idx)
    matrix.each { |row| row[col_idx] = 0 }
end