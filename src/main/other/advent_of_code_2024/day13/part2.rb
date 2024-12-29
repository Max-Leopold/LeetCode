input = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true)
  .each_slice(4).map { |a, b, p, _|
    regex = /X[\+=](\d+),\s*Y[\+=](\d+)/
    [a.scan(regex), b.scan(regex), p.scan(regex)].map { _1.first.map(&:to_f) }
  }

pp input.sum { |(x1, y1), (x2, y2), (c1, c2)|
  c1, c2 = c1 + 10000000000000, c2 + 10000000000000
  b = ((c1 * -(y1 / x1) + c2) / (x2 * -(y1 / x1) + y2)).round
  a = ((c1 - x2 * b) / x1).round
  a * x1 + b * x2 == c1 && a * y1 + b * y2 == c2 && a > 0 && b > 0 ? a * 3 + b  : 0
}