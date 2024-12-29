# The +9 and +101 Numbers for the steps are chosen because I noticed a 
# recurring pattern where most robots are vertically aligned.
# Turns out just looking at a couple of those pictures gives you the Christmas tree picture

require "Set"

input = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true)
  .map { _1.scan(/p=(\d+),(\d+)\sv=(-?\d+),(-?\d+)/).first.map(&:to_i) }
  .map { |x, y, dx, dy| [(x + dx * 9) % 101, (y + dy * 9) % 103, dx, dy] }

def print_robots(positions)
  103.times do |y|
    101.times do |x|
      print positions.include?([x, y]) ? "*" : " "
    end
    puts ""
  end

  puts "-" * 101
end

100.times do 
  input = input.map { |x, y, dx, dy| [(x + dx * 101) % 101, (y + dy * 101) % 103, dx, dy] }
  puts "Seconds:  #{(_1 + 1) * 101 + 9}"
  print_robots(input.map { |x, y, _, _| [x, y]}.to_set )
end