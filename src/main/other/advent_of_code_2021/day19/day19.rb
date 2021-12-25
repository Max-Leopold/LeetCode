require 'set'
require_relative 'scanner'

scanner_strings = File.read(File.join(File.dirname(__FILE__), "input.txt")).split(/\n{2,}/)

def create_scanner(scanner_strings)
    scanner_strings.map {|scanner_string|
        coords = scanner_string.split("\n")[1..-1].map {|cord| cord.split(",").map(&:to_i)}
        Scanner.new(coords)
    }
end

scanners = create_scanner(scanner_strings)
scanner_0 = scanners[0]
unknown_scanners = scanners[1..-1]
current_scanner = scanner_0
current_scanner.abs_position = [0, 0, 0]

def find_match(scanner_0, current_scanner, unknown_scanners)
    unknown_scanners.each {|testing_scanner|
        # Check if current_scanner matches with testing_scanner
        current_scanner.beacons.each {|current_scanner_point|
            current_scanner_point_distances = Scanner.distances_to_point(current_scanner.beacons, *current_scanner_point)
            testing_scanner.all_rotations.each {|testing_scanner_rotation|
                testing_scanner_rotation.each {|testing_scanner_point|
                testing_scanner_point_distances = Scanner.distances_to_point(testing_scanner_rotation, *testing_scanner_point)
                intersecting_distances = (current_scanner_point_distances & testing_scanner_point_distances).flat_map do |n| 
                    [n]*[current_scanner_point_distances.count(n), testing_scanner_point_distances.count(n)].min
                end
                # Possible match
                if intersecting_distances.length >= 12
                    # Check each rotation for a match
                    offset = [
                        current_scanner_point[0] - testing_scanner_point[0], 
                        current_scanner_point[1] - testing_scanner_point[1],
                        current_scanner_point[2] - testing_scanner_point[2]
                    ]
                    offsetted_points = Scanner.offset_beacons(testing_scanner_rotation, *offset)
                    intersecting_points = offsetted_points & current_scanner.beacons

                    if intersecting_points.length >= 12
                        # Found match

                        # Abs position to scanner 0
                        testing_scanner.abs_position = offset.zip(current_scanner.abs_position).map(&:sum)

                        # Set the correct orientation as beacons for the scanner
                        testing_scanner.beacons = testing_scanner_rotation

                        points_relative_to_scanner_0 = Scanner.offset_beacons(offsetted_points, *current_scanner.abs_position)

                        current_scanner = testing_scanner
                        unknown_scanners.delete testing_scanner
                        scanner_0.add_beacons points_relative_to_scanner_0
                        return current_scanner
                    end
                end
                }
            }
        }
    }
    raise "Could not find match for scanner #{current_scanner}"
end

def manhatten_distance(scanner1, scanner2)
    (scanner1[0] - scanner2[0]).abs + (scanner1[1] - scanner2[1]).abs + (scanner1[2] - scanner2[2]).abs
end

known_scanners = [scanner_0]
while !unknown_scanners.empty? do
    puts "There are #{unknown_scanners.length} scanners with unknown locations left"
    current_scanner = find_match(scanner_0, scanner_0, unknown_scanners)
    known_scanners << current_scanner
end

known_scanner_pairs = known_scanners.permutation(2).to_a
manhatten_distances = known_scanner_pairs.map {|scanner1, scanner2|
    manhatten_distance(scanner1.abs_position, scanner2.abs_position)
}

puts "Day 19, Part 1: In total there are #{scanner_0.beacons.length} beacons"
puts "Day 19, Part 2: The largest manhatten distance between any two beacons is #{manhatten_distances.max}"
