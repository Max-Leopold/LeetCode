class Point
    attr_reader :x, :y

    def initialize(x, y)
        @x = x
        @y = y
    end

    def ==(other)
        @x == other.x && @y == other.y
    end

    alias :eql? :==

    def hash
        self.to_s.hash
    end

    def to_s
        "[#{@x}, #{@y}]"
    end
end

def create_points(start_point, end_point)
    xDiff = (end_point.x - start_point.x).abs
    yDiff = (end_point.y - start_point.y).abs

    if xDiff != 0 && yDiff == 0
        start_point, end_point = end_point, start_point if start_point.x > end_point.x
        (start_point.x..end_point.x).map {|x|
            Point.new(x, start_point.y)
        }
    elsif xDiff == 0 && yDiff != 0
        start_point, end_point = end_point, start_point if start_point.y > end_point.y
        (start_point.y..end_point.y).map {|y|
            Point.new(start_point.x, y)
        }
    elsif xDiff == yDiff
        start_point, end_point = end_point, start_point if start_point.x > end_point.x
        slope = (end_point.y - start_point.y) / (end_point.x - start_point.x)
        (0..xDiff).map {|step|
            Point.new(start_point.x + step, start_point.y + step * slope)
        }
    else 
        []
    end
end

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")

start_end_points = input.map {|line| 
    start_point, end_point = line.split(" -> ").map {|p| 
        x, y = p.split(",").map(&:to_i)
        Point.new(x, y)
    }
}

part1_points = start_end_points.select {|p1, p2| p1.x == p2.x || p1.y == p2.y}.map {|p1, p2| create_points(p1, p2)}.flatten
part2_points = start_end_points.map {|p1, p2| create_points(p1, p2)}.flatten

puts "Day 5, Part 1: Total points with at least two intersecting lines: #{part1_points.tally.values.count {|count| count > 1}}"
puts "Day 5, Part 1: Total points with at least two intersecting lines: #{part2_points.tally.values.count {|count| count > 1}}"