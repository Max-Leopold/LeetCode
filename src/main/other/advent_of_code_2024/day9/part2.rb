# Probably some of the worst code to understand that I've written in some time. But I had fun :)
# The challenge is that we try to not allocate any additional (non constant) memory apart from the input.

INPUT = File.readlines(File.join(File.dirname(__FILE__), "INPUT.txt"), chomp: true).first.chars.map(&:to_i)
startp, endp, sum = 0, INPUT.count - 1, 0

def pos_multiplier(startp, endp)
  pos = INPUT[0...startp].map { _1 / 10 + _1 % 10 }.sum
  (pos...(pos + INPUT[endp] % 10)).sum
end

def move_file(startp, endp)
  while startp < endp
    if INPUT[startp] >= INPUT[endp] % 10
      pos_multiplier = pos_multiplier(startp, endp)
      INPUT[startp] -= INPUT[endp] % 10
      INPUT[startp - 1] = INPUT[startp - 1] % 10 + (INPUT[startp - 1] / 10 + INPUT[endp] % 10) * 10
      return pos_multiplier * (endp / 2).to_i
    end
    startp += 2
  end
  pos_multiplier(endp, endp) * (endp / 2).to_i
end

while startp <=  endp
  if startp.even?
    sum += pos_multiplier(startp, startp) * (startp / 2).to_i
    startp += 1
  else
    sum += move_file(startp, endp)
    endp -= 2
  end
end

puts sum