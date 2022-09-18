# @param {Integer[][]} properties
# @return {Integer}
def number_of_weak_characters(properties)
  properties.sort! do |x, y|
    if x[0] != y[0]
      x[0] <=> y[0]
    else
      y[1] <=> x[1]
    end
  end
  stack = []
  weak = 0
  properties.each do |_, defense|
    while !stack.empty? && stack.last < defense
      stack.pop
      weak += 1
    end
    stack << defense
  end

  weak
end
