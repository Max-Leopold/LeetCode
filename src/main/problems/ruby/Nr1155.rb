# @param {Integer} n
# @param {Integer} k
# @param {Integer} target
# @return {Integer}
def num_rolls_to_target(n, k, target, memo = {})
  return memo[[n, target]] if memo[[n, target]]
  return 1 if n == 0 && target == 0
  return 0 if n == 0

  combinations = 0
  memo[[n, target]] = (1..k).sum(0) do |dice_roll|
    num_rolls_to_target(n - 1, k, target - dice_roll, memo)
  end % (10 ** 9 + 7)
end
