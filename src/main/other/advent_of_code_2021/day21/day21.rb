require_relative 'quantum_dice_game'
require_relative 'dice_game'
require_relative 'practice_dice'
require_relative 'quantum_dice'

practice_dice = PracticeDice.new
player1, player2, dice = DiceGame.play_game(8, 3, practice_dice)

part1_solution = player1.won? ? dice.rolls * player2.points : dice.rolls * player1.points
puts "Day 21, Part 1: #{part1_solution}"

quantum_dice = QuantumDice.new
wins = QuantumDiceGame.play_game(8, 3, quantum_dice)
puts "Day 21, Part 2: The player with the most wins wins #{wins.max} times"