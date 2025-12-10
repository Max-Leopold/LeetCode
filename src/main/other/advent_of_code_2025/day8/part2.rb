require "matrix"

junctions = File.readlines(File.join(__dir__, "input.txt"), chomp: true)
  .map { Vector[*it.split(",").map(&:to_i)] }
  
result = junctions.combination(2)
  .sort_by { (_1 - _2).r }
  .each_with_object([]) do |v, circuits|
    with_v, without_v = circuits.partition { _1.intersect?(v) }
    circuits.replace([*without_v, with_v.reduce(Set.new(v), :+)])
    break v.map(&:first).reduce(:*) if circuits.first.size == junctions.size
  end

pp result