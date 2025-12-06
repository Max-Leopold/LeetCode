result = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true)
  .take_while { !it.empty? }
  .map { |line| Range.new(*line.split("-").map(&:to_i)) }
  .sort_by(&:begin)
  .reduce([0, 0]) do |(sum, i_end), interval|
    [
      sum + [(interval.begin <= i_end ? interval.end - i_end : interval.size), 0].max,
      [i_end, interval.max].max
    ]
  end.first
  
pp result