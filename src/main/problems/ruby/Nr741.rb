# @param {Integer[][]} grid
# @return {Integer}
def cherry_pickup(grid)
  max_cherries = walk(grid, 0, 0, 0, 0)
  max_cherries == -1 ? 0 : max_cherries
end

def walk(grid, r_1, c_1, r_2, c_2, memo = {})
  return memo[[r_1, c_1, r_2, c_2]] if memo[[r_1, c_1, r_2, c_2]]
  return 0 if r_1 == grid.size - 1 && r_2 == grid.size - 1 && c_1 == grid[r_1].size && c_2 == grid[r_2].size
  return -1 if r_1 >= grid.size || r_2 >= grid.size || c_1 >= grid[r_1].size || c_2 >= grid[r_2].size
  return -1 if grid[r_1][c_1] == -1 || grid[r_2][c_2] == -1

  max_cheries = 0
  pos_1_prev = grid[r_1][c_1]
  if pos_1_prev == 1
    max_cheries += 1
    grid[r_1][c_1] = 0
  end

  pos_2_prev = grid[r_2][c_2]
  if pos_2_prev == 1
    max_cheries += 1
    grid[r_2][c_2] = 0
  end

  max_found_cherries = [walk(grid, r_1 + 1, c_1, r_2 + 1, c_2, memo),
    walk(grid, r_1 + 1, c_1, r_2, c_2 + 1, memo),
    walk(grid, r_1, c_1 + 1, r_2 + 1, c_2, memo),
    walk(grid, r_1, c_1 + 1, r_2, c_2 + 1, memo)].max

  #
  grid[r_2][c_2] = pos_2_prev
  grid[r_1][c_1] = pos_1_prev

  max_cheries = max_found_cherries >= 0 ? max_found_cherries + max_cheries : -1
  memo[[r_1, c_1, r_2, c_2]] = max_cheries
end
