# @param {Integer} n
# @return {Integer}
def two_egg_drop(n)
  # Solve the equation using the quadratic formula
  # a = 1, b = 2, c = -2n
  ((-1 + Math.sqrt(1 + 8 * n)) / 2).ceil
end
