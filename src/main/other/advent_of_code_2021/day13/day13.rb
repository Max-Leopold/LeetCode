require 'set'

def fold_x(x, points)
    stay, fold = points.partition {|point| point[0] < x}
    fold.each do |point|
        point[0] = point[0] - (point[0] - x).abs * 2
    end
    (stay + fold).to_set
end

def fold_y(y, points)
    stay, fold = points.partition {|point| point[1] < y}
    fold.each do |point|
        point[1] = point[1] - (point[1] - y).abs * 2
    end
    (stay + fold).to_set
end

def fold(folds, points)
    folds.each {|axis, line|
        case axis
        when "x"
            points = fold_x(line.to_i, points)
        when "y"
            points = fold_y(line.to_i, points)
        end
    }
    points
end

def print_coordinates(points)
    max_x = points.max_by {|x, y| x}.first
    max_y = points.max_by {|x, y| y}.last
    (0..max_y).each {|y|
        puts (0..max_x).map {|x|
            points.include?([x, y]) ? " * " : "   "
        }.join
    }
end

points = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map {|line| 
    line.chomp.split(",").map(&:to_i)
}.to_set

folds = File.open(File.join(File.dirname(__FILE__), "folds.txt"), "r").map {|line|
    line.chomp.split("=")
}

points_after_first_fold = fold([folds[0]], points)
points_after_all_folds = fold(folds, points)
puts "Day 13, Part 1: After one fold there are #{points_after_first_fold.length} points."
puts "Day 13, Part 2: After all folds the points form those letters:\n\n"
print_coordinates points_after_all_folds

