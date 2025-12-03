def invalid_product_enumerator(r_start, length)
  repeating_part, repeat = 10 ** (length - 1), 2
  Enumerator.new do |y|
    loop do
      repeating_part, repeat = 10 ** (length - 1), repeat + 1 if repeating_part >= 10 ** length
      y << (repeating_part.to_s * repeat).to_i
      repeating_part += 1
    end
  end
end

result = File.readlines(File.join(File.dirname(__FILE__), "input.txt"), "r").first
  .split(",")
  .map { |range| range.split("-").map(&:to_i) }
  .flat_map do |r_start, r_end|
    1.upto(r_end.to_s.size / 2).flat_map do |length|
      invalid_product_enumerator(r_start, length).lazy.drop_while {|p| p < r_start }.take_while { |p| p <= r_end}.to_a
    end.uniq
  end.sum

pp result

