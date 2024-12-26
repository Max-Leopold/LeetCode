# I know that you are supposed to count the corners of a region but collecting all fences + direction and then 
# grouping them into sides is more fun :)

INPUT = File.readlines(File.join(File.dirname(__FILE__), "INPUT.txt"), chomp: true).map(&:chars)
GRID = INPUT.each_with_index.flat_map { |row, y| row.each_with_index.map { |val, x| [Complex(x, y), val] } }.to_h
DIRS = [1, -1, 1i, -1i]

def walk(pos, char)
  return [0, []] if GRID[pos] != char
  GRID[pos] = ""
  fence_directions = DIRS.select { 
    np = _1 + pos
    !np.real.between?(0, INPUT.first.count - 1) || !np.imag.between?(0, INPUT.count - 1) || INPUT[np.imag][np.real] != char
  }.map { [pos, _1] }
  [1, fence_directions].tap { |result|
    DIRS.each { |d|
      area, fences = walk(d + pos, char)
      result[0] += area
      result[1] += fences
    }
  }
end

pp GRID.sum { |key, val| 
  next 0 if val == ""
  area, fences = walk(key, val)
  DIRS.sum { |dir|
    fences.select { _1.last == dir }
          .map(&:first)
          .group_by { dir.real == 0 ? _1.imag : _1.real }
          .transform_values { |v| v.map { dir.real == 0 ? _1.real : _1.imag }.sort }
          .sum { |_, v| v.chunk_while { |i, j| i + 1 == j }.count }
  } * area
}