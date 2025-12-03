def invalid_product_enumerator(start)
  part = start.to_s[0...(start.to_s.size / 2)]
  Enumerator.new do |y|
    loop do
      y << (part * 2).to_i
      part = (part.to_i + 1).to_s
    end
  end
end

result = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), "r").first
  .split(",")
  .map { |range| range.split("-").map(&:to_i) }
  .flat_map do |r_start, r_end|
    invalid_product_enumerator(r_start).lazy.drop_while {|p| p < r_start }.take_while { |p| p <= r_end}.to_a
  end.sum

pp result

