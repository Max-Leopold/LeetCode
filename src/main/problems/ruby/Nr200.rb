# @param {Character[][]} grid
# @return {Integer}
def num_islands(grid)
    islands = 0
    grid.each_with_index do |row, row_idx|
        row.each_with_index do |col, col_idx|
            if col == '1'
                islands += 1
                color_island(grid, row_idx, col_idx)
            end
        end
    end
    islands
end

def color_island(grid, row, column)
    return if row < 0 || row > grid.size
    return if column < 0 || column > grid[row].size
    return unless grid[row][column] == '1'

    grid[row][column] = '0'
    color_island(grid, row + 1, column)
    color_island(grid, row - 1, column)
    color_island(grid, row, column + 1)
    color_island(grid, row, column - 1)
end