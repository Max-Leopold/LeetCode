input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp).chunk_while { [_1, _2].none?(&:empty?) }.to_a

operations = input.first.map do |line|
    name, *operations, default = line.split(/[{},]/)
    operations = operations.map do |operation|
        cond, dest = operation.split(":")
        ->(obj) { obj[cond[0]].send(cond[1].to_sym, cond[2..].to_i) ? dest : nil }
    end
    [name, operations + [->(obj) { default }]]
end.to_h
objects = input.last.map { |obj| ["x", "m", "a", "s"].zip(obj.split(/[=,}]/).reject { _1.to_i.to_s != _1 }.map(&:to_i)).to_h }

res = objects.sum do |obj|
    state = "in"
    state = operations[state].filter_map { _1.(obj) }.first until ["A", "R"].include?(state) 
    state == "A" ? obj.values.sum : 0
end

pp res