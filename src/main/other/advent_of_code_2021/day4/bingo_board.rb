class BingoBoard
    
    def initialize(grid)
        @grid = grid
        @winning_lines = grid + grid.transpose
    end

    def won?(numbers)
        @winning_lines.any? {|winning_line|
            (winning_line - numbers).empty?
        }
    end

    def solution(numbers)
        sum_non_used = @grid.map {|row|
            row - numbers
        }.flatten.inject(:+)
        sum_non_used * numbers[-1]
    end

    def to_s
        @grid
    end

end