result = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")
  .map { it.chomp.chars }
  .map do |bank|
    12.times.reduce(["", 0]) do |(num, idx), iteration|
      battery = bank[idx..(-12 + iteration)].each_with_index.max_by(&:first)
      [num << battery.first, idx + battery.last + 1]
    end.first.to_i
  end.sum

pp result