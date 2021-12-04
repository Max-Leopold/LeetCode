require_relative "bingo_board"

input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r")

drawn_numbers = input.readline.split(",").map(&:to_i)
input.readline

def create_bingo_boards(input)
    input.each_line.reject { |line| line.start_with?(/\r|\n/) }
    .each_slice(5)
    .map { |board| 
        BingoBoard.new( board.map { |row| 
            row.split(" ").map(&:to_i) 
        })
    }
end 

def get_winning_bingo_board(bingo_boards, drawn_numbers)
    drawn_numbers.each_index {|index|
        winning_bingo_board = bingo_boards.find {|bingo_board|
            bingo_board.won?(drawn_numbers[...index])
        }
        return index, winning_bingo_board if winning_bingo_board
    }
end

bingo_boards = create_bingo_boards(input)
index, winning_bingo_board = get_winning_bingo_board(bingo_boards, drawn_numbers)
puts "Day 4, Part 1: Solution: #{winning_bingo_board.solution(drawn_numbers[...index])}"

def get_last_winning_bingo_board(bingo_boards, drawn_numbers)
    drawn_numbers.each_index {|index|
        bingo_boards = bingo_boards.select {|bingo_board|
            !bingo_board.won?(drawn_numbers[...index])
        }
        return get_winning_bingo_board([bingo_boards[0]], drawn_numbers) if bingo_boards.length == 1
    }
end

index, last_winning_bingo_board = get_last_winning_bingo_board(bingo_boards, drawn_numbers)
puts "Day 4, Part 2: Solution: #{last_winning_bingo_board.solution(drawn_numbers[...index])}"
