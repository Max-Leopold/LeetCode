input = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), chomp: true).first.chars.map(&:to_i)
startp, endp, sum, pos = 0, input.count - 1, 0, 0

while startp <= endp
  if input[startp] <= 0 then startp += 1; next; end
  if input[endp] <= 0 then endp -= 2; next; end
  if startp.even?
    sum = sum + (pos * (startp / 2).to_i)
  else
    sum, input[endp] = sum + (pos * (endp / 2).to_i), input[endp] - 1
  end
  input[startp] -= 1
  pos += 1
end

puts sum