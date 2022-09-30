# @param {Integer[]} temperatures
# @return {Integer[]}
def daily_temperatures(temperatures)
  stack = []
  res = Array.new(temperatures.size) { 0 }
  temperatures.each_with_index do |temp, i|
    while !stack.empty? && temperatures[stack.last] < temp
      index = stack.pop
      res[index] = i - index
    end

    stack << i
  end

  res
end
