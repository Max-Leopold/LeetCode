def pacific_atlantic(heights)
    pacific_visited = Array.new(heights.size) { Array.new(heights[0].size) }
    atlantic_visited = Array.new(heights.size) { Array.new(heights[0].size) }

    (0...heights.size).each do |row|
        dfs(heights, row, heights[0].size - 1, atlantic_visited, -1)
        dfs(heights, row, 0, pacific_visited, -1)
    end

    (0...heights[0].size).each do |column|
        dfs(heights, heights.size - 1, column, atlantic_visited, - 1)
        dfs(heights, 0, column, pacific_visited, -1)
    end

    res = []
    heights.each_with_index do |row, row_idx|
        row.each_with_index do |col, col_idx|
            res << [row_idx, col_idx] if pacific_visited[row_idx][col_idx] && atlantic_visited[row_idx][col_idx]
        end
    end

    res
end

def dfs(heights, row, column, visited, prev)
    return if row < 0 || row >= heights.size
    return if column < 0 || column >= heights[row].size
    return if visited[row][column]
    return if heights[row][column] < prev

    visited[row][column] = true

    dfs(heights, row + 1, column, visited, heights[row][column])
    dfs(heights, row - 1, column, visited, heights[row][column])
    dfs(heights, row, column + 1, visited, heights[row][column]) 
    dfs(heights, row, column - 1, visited, heights[row][column])
end