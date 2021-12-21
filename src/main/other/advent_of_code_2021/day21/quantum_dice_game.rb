require_relative '../../../util/ruby/cache'

class QuantumDiceGame
    extend Cacheable

    def self.play_game(player1_pos, player2_pos, dice)
        game = QuantumDiceGame.new
        game.play_game(player1_pos, 0, player2_pos, 0, 0, true, 0, dice)
    end

    private
    
    cache :play_game, -> (player1_pos, player1_points, player2_pos, player2_points, dice_roll, player1_turn, dices_rolled, dice) \
        {("#{player1_pos}, #{player1_points}, #{player2_pos}, #{player2_points}, #{dice_roll}, #{player1_turn}, #{dices_rolled}, #{dice}")}
    # Only reason this isn't a class method is that my custom Cacheable module can't cache class methods
    def play_game(player1_pos, player1_points, player2_pos, player2_points, dice_roll, player1_turn, dices_rolled, dice)
        if player1_turn
            player1_pos += dice_roll
            if player1_pos > 10
                player1_pos -= 10
            end
            if dices_rolled == 3
                player1_points += player1_pos
                if player1_points >= 21
                    return [1, 0]
                end
                return play_game(player1_pos, player1_points, player2_pos, player2_points, 0, false, 0, dice)
            end 
            return dice.possible_rolls.map {|dice_roll|
                play_game(player1_pos, player1_points, player2_pos, player2_points, dice_roll, true, dices_rolled + 1, dice)
            }.transpose.map(&:sum)
        else 
            player2_pos += dice_roll
            if player2_pos > 10
                player2_pos -= 10
            end
            if dices_rolled == 3
                player2_points += player2_pos
                if player2_points >= 21
                    return [0, 1]
                end
                return play_game(player1_pos, player1_points, player2_pos, player2_points, 0, true, 0, dice)
            end 
            return dice.possible_rolls.map {|dice_roll|
                play_game(player1_pos, player1_points, player2_pos, player2_points, dice_roll, false, dices_rolled + 1, dice)
            }.transpose.map(&:sum)
        end
    end
end