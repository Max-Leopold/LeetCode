input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).map { _1.split(" ").map(&:to_i) }

def predict_seq(history)
    diff = history.each_cons(2).map { |i, j| j - i }
    diff.all?(&:zero?) ? 0 : diff[-1] + predict_seq(diff)
end

pp input.map { _1[-1] + predict_seq(_1) }.sum