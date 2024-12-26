require "Set"

INPUT = File.readlines(File.join(File.dirname(__FILE__), "INPUT.txt"), chomp: true).map(&:chars).map { _1.map(&:to_i) }
HASH_INPUT = Hash[INPUT.each_with_index.flat_map { |row, y| row.each_with_index.map { |val, x| [Complex(x, y), val] } }]
DP, DIRS = {}, [Complex(1, 0), Complex(-1, 0), Complex(0, 1), Complex(0, -1)]

def walk(pos)
  return DP[pos] if DP[pos]
  return 1 if HASH_INPUT[pos] == 9 
  DP[pos] = DIRS.map { 
    next_pos = pos + _1
    next_pos.imaginary.between?(0, INPUT.count - 1) && next_pos.real.between?(0, INPUT.first.count - 1) && HASH_INPUT[next_pos] - HASH_INPUT[pos] == 1 ? walk(next_pos) : 0
  }.sum
end

pp HASH_INPUT.sum { |k, v| v == 0 ? walk(k) : 0}