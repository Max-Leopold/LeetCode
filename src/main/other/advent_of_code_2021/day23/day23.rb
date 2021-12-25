require_relative '../../../util/ruby/cache'

$room_positions = {A: 2, B: 4, C: 6, D: 8}
$move_costs = {A: 1, B: 10, C: 100, D: 1000}
$possible_top_positions = [0, 1, 3, 5, 7, 9, 10]

# Input
# -----
rooms_part1 = Array.new
rooms_part1[2] = [:C, :B]
rooms_part1[4] = [:D, :A]
rooms_part1[6] = [:A, :D]
rooms_part1[8] = [:B, :C]

rooms_part2 = Array.new(11)
rooms_part2[2] = [:C, :D, :D, :B]
rooms_part2[4] = [:D, :C, :B, :A]
rooms_part2[6] = [:A, :B, :A, :D]
rooms_part2[8] = [:B, :A, :C, :C]
# -----

class Day23
    extend Cacheable

    cache :move, -> (top) {top.to_s}
    # Only reason this isn't a class method is that my custom Cacheable module currently doesn't support class methods
    def move(top)
        # Check if all amphipods are in the correct room
        if $room_positions.all? {|sym_at_x, x|
            room = top[x]
            room.all?(sym_at_x)
        }
            puts "Found solution"
            return 0
        end
        costs = []
        # Try to move amphipod into a room
        # First check if one amphipode can got into destination room
        $possible_top_positions.each {|x|
            if !top[x].nil?
                sym_at_x = top[x]
                destination_room = top[$room_positions[sym_at_x]]
                # Check amphipode could go into room
                if !destination_room.find {|entry| entry != nil && entry != sym_at_x}
                    # Check if the route to the room is free
                    moves_left = $room_positions[sym_at_x] < x
                    range = moves_left ? ($room_positions[sym_at_x]..(x - 1)) : ((x + 1)..$room_positions[sym_at_x])
                    if $possible_top_positions.all? {|top_position|
                        if range.include?(top_position)
                            top[top_position].nil?
                        else
                            true
                        end
                    }
                        # Calculate cost of move
                        cost_of_move = (x - $room_positions[sym_at_x]).abs
                        rindex = destination_room.index {|entry| !entry.nil?}
                        if rindex
                            cost_of_move += destination_room.length - rindex
                        else 
                            cost_of_move += destination_room.length
                        end

                        cost_of_move *= $move_costs[sym_at_x]

                        # Move
                        top[x] = nil

                        if rindex
                            destination_room[rindex - 1] = sym_at_x
                        else
                            destination_room[destination_room.length - 1] = sym_at_x
                        end
                        # pp top

                        # -------
                        # Do next move here
                        next_move_cost = move(top)
                        if next_move_cost != -1
                            costs << next_move_cost + cost_of_move
                        else
                            costs << -1
                        end
                        # -------

                        # Revert move
                        top[x] = sym_at_x
                        if rindex
                            destination_room[rindex - 1] = nil
                        else
                            destination_room[destination_room.length - 1] = nil
                        end
                    end
                end
            end
        }
        # Move amphipod out of a room
        $room_positions.each {|sym_at_x, x|
            room = top[x]
            # Check if room is already correct 
            if !room.all? {|entry| entry == sym_at_x || entry == nil}
                # Check if there is a amphipod to be moved
                index_that_could_be_moved = room.index {|sym| !sym.nil?}
                if index_that_could_be_moved
                    sym_that_could_be_move = room[index_that_could_be_moved]
                    # First try moves to the right
                    right_bound = x + 1
                    while top[right_bound].nil?
                        # Move
                        room[index_that_could_be_moved] = nil
                        top[right_bound] = sym_that_could_be_move
                        cost = (index_that_could_be_moved + (x - right_bound).abs + 1) * $move_costs[sym_that_could_be_move]

                        # -----
                        # Do next move here
                        next_move_cost = move(top)
                        # -----

                        # Revert move
                        room[index_that_could_be_moved] = sym_that_could_be_move
                        top[right_bound] = nil
                        if next_move_cost != -1
                            costs << next_move_cost + cost
                        else
                            costs << -1
                        end

                        next_possible_top_positions_index = $possible_top_positions[$possible_top_positions.index(right_bound) + 1]
                        if next_possible_top_positions_index.nil?
                            break
                        end
                        right_bound = next_possible_top_positions_index
                    end

                    # Try move to left
                    left_bound = x - 1
                    while top[left_bound].nil?
                        # Move
                        room[index_that_could_be_moved] = nil
                        top[left_bound] = sym_that_could_be_move
                        cost = (index_that_could_be_moved + (x - left_bound).abs + 1) * $move_costs[sym_that_could_be_move]

                        # -----
                        # Do next move here
                        next_move_cost = move(top)
                        # -----

                        # Revert move
                        room[index_that_could_be_moved] = sym_that_could_be_move
                        top[left_bound] = nil

                        if next_move_cost != -1
                            costs << next_move_cost + cost
                        else
                            costs << -1
                        end

                        next_possible_top_positions_index = $possible_top_positions.index(left_bound) - 1
                        if next_possible_top_positions_index < 0
                            break
                        end
                        left_bound = $possible_top_positions[next_possible_top_positions_index]
                    end
                end
            end
        }

        if costs.empty?
            return -1
        elsif costs.all?(-1)
            return -1
        else
            return costs.select {|cost| cost != -1}.min
        end
    end
end

day23 = Day23.new

puts "Day 23, Part 1: The least energy to organize the amphipods is #{day23.move(rooms_part1)}"
puts "Day 23, Part 2: The least energy to organize the amphipods is #{day23.move(rooms_part2)}"