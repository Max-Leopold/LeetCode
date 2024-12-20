result = File.readlines(File.join(File.dirname(__FILE__), "input.txt"))
  .sum { |line| line.scan(/mul\((\d*),(\d*)\)/).sum { |x, y| x.to_i * y.to_i}}

pp result