class PracticeDice 
    attr_reader :rolls

    def initialize
        @rolls = 0
        @next_num = 0
    end

    def roll_dice
        @rolls += 1
        if @next_num >= 100
            @next_num = 1
            return @next_num
        else
            @next_num += 1
            return @next_num
        end
    end
end