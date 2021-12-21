require_relative 'player'

class DiceGame

    def self.play_game(player1_pos, player2_pos, dice)
        player1 = Player.new(player1_pos)
        player2 = Player.new(player2_pos)

        while true
            moving_fields = dice.roll_dice + dice.roll_dice + dice.roll_dice
            player1.move_forward moving_fields
            break if player1.won?

            moving_fields = dice.roll_dice + dice.roll_dice + dice.roll_dice
            player2.move_forward moving_fields
            break if player2.won?
        end

        return player1, player2, dice
    end
end