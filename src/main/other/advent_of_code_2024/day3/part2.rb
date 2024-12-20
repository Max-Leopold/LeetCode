result = File.readlines(File.join(File.dirname(__FILE__), "input.txt")).join(" ")
  .then do |line|
    mul = true
    line.scan(/mul\((\d*),(\d*)\)|(do\(\)|don\'t\(\))/).sum do |x, y, z|
      z ? (mul = z == "do()"; 0) : (mul ? x.to_i * y.to_i : 0)
    end
  end

pp result