input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map {|line| line.chomp.split("")}

def move_east_facing(input)
    moved = false
    input.each.with_index {|row, row_index|
        to_move = (0...row.length).select {|column_index|
            row[column_index] == ">" && row[(column_index + 1) % row.length] == "."
        }
        to_move.each {|index_to_move|
            row[index_to_move] = "."
            row[(index_to_move + 1) % row.length] = ">"
        }
        moved = moved || to_move.length > 0
    }
    moved
end

def move_south_facing(input)
    moved = false
    input.transpose.each.with_index {|column, column_index|
        to_move = (0...column.length).select {|row_index|
            column[row_index] == "v" && input[(row_index + 1) % column.length][column_index] == "."
        }
        to_move.each {|index_to_move|
            input[index_to_move][column_index] = "."
            input[(index_to_move + 1) % column.length][column_index] = "v"
        }
        moved = moved || to_move.length > 0
    }
    moved
end

steps = 0
move_further = true
while move_further
    movement_east = move_east_facing(input)
    movement_south = move_south_facing(input)
    move_further = movement_east || movement_south
    steps += 1
end

puts "Day 25, Part 1: After #{steps} steps the cucumbers don't move anymore"