input = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true)
  .each_slice(4).map { |a, b, p, _|
    regex = /X[\+=](\d+),\s*Y[\+=](\d+)/
    [a.scan(regex), b.scan(regex), p.scan(regex)].map { _1.first.map(&:to_i) }
  }

result = input.sum { |a, b, p| 
  b_count = [p[0] / b[0], p[1] / b[1], 100].min
  p[0], p[1] = p[0] - b[0] * b_count, p[1] - b[1] * b_count
  a_count = [p[0] / a[0], p[1] / a[1], 100].min
  p[0], p[1] = p[0] - a[0] * a_count, p[1] - a[1] * a_count

  while a_count <= 100
    p[0], p[1], a_count = p[0] - a[0], p[1] - a[1], a_count + 1
    p[0], p[1], b_count = p[0] + b[0], p[1] + b[1], b_count - 1 while (p[0] < 0 || p[1] < 0) && b_count > 0
    break if p[0] == 0 && p[1] == 0
  end

  p[0] == 0 && p[1] == 0 ? b_count + 3 * a_count : 0
}

pp result