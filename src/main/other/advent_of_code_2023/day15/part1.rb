input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).first.split(",").map(&:chars)

res = input.sum do |step|
    step.inject(0) { ((_1 + _2.ord) * 17) % 256 }
end

pp res