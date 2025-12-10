require "matrix"

result = File.readlines(File.join(__dir__, "input.txt"), chomp: true)
  .map { Vector[*it.split(",").map(&:to_i)] }
  .combination(2)
  .sort_by { (_1 - _2).r }
  .first(1000)
  .reduce([]) do |agg, v|
    with_v, without_v = agg.partition { _1.intersect?(v) }
    [*without_v, with_v.reduce(Set.new(v), :+)]
  end.map(&:size).sort[-3..].reduce(:*)

pp result