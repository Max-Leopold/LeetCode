class Player 
    attr_reader :points, :pos

    def initialize(pos)
        @pos = pos - 1
        @points = 0
    end

    def move_forward(fields)
        @pos = (@pos + fields) % 10
        @points += (@pos + 1)
    end

    def won?
        @points >= 1000
    end
end