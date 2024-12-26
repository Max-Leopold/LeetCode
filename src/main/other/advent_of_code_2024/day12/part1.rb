INPUT = File.readlines(File.join(File.dirname(__FILE__), "INPUT.txt"), chomp: true).map(&:chars)
GRID = INPUT.each_with_index.flat_map { |row, y| row.each_with_index.map { |v, x| [Complex(x, y), v] } }.to_h
DIRS = [1, -1, 1i, -1i]

def walk(pos, char)
  return 0 unless GRID[pos] == char
  GRID[pos] = ""
  fences = DIRS.count { |d| 
    np = pos + d
    !np.real.between?(0, INPUT[0].size - 1) || !np.imag.between?(0, INPUT.size - 1) || INPUT[np.imag][np.real] != char
  }
  Complex(1, fences) + DIRS.sum { walk(pos + _1, char) }
end

pp GRID.sum { |k, v| v == "" ? 0 : (r = walk(k, v); r.real * r.imag) }