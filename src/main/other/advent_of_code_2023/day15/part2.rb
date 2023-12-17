input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).first.split(",").map { _1.split(/[-=]/) }

boxes = Array.new(256) { {} }
input.each do |instruction|
    box = instruction[0].split("").inject(0) { ((_1 + _2.ord) * 17) % 256 }
    boxes[box].delete(instruction[0]) if instruction.size == 1
    boxes[box][instruction[0]] = instruction[1] if instruction.size == 2
end

res = boxes.each_with_index.sum do |box, box_i|
    box.each_with_index.sum { |(_, focal_length), lens_i| (box_i + 1) * focal_length.to_i * (lens_i + 1) }
end

pp res