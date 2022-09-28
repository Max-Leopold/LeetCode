# @param {Integer[]} nums
# @return {Integer}
def total_steps(nums)
  stack = []
  res = 0
  i = 0

  nums.each do |num|
    while !stack.empty? && stack.last[0] <= num
      elem = stack.pop
      res = [res, elem[1]].max
      stack.last[1] = [stack.last[1], elem[1]].max unless stack.empty?
    end

    stack.last[1] += 1 unless stack.empty?
    stack << [num, 0]
  end
  stack.each { |elem| res = [res, elem[1]].max }

  res
end
