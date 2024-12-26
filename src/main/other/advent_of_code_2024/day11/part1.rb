counters = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").gets.split(" ").map(&:to_i).tally

25.times do
  counters = counters.each_with_object(Hash.new(0)) do |(stone, count), new_counters|
    case
    when stone == 0 then new_counters[1] += count
    when stone.to_s.size.even?
      s = stone.to_s
      new_counters[s[0...(s.size/2)].to_i] += count
      new_counters[s[(s.size/2)...].to_i] += count
    else new_counters[stone * 2024] += count
    end
  end
end

pp counters.values.sum