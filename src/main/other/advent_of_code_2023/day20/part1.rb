input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

FlipFlop = Struct.new(:name, :incoming, :dests, :state) do
    def propagate(pulse, origin)
        self.state = !self.state unless pulse
        pulse ? [] : dests.map { [name, state, _1] }
    end
end

Conjunction = Struct.new(:name, :incoming, :dests) do
    def propagate(pulse, origin)
        self.incoming[origin] = pulse
        dests.map { [name, !incoming.values.all?, _1] }
    end
end

Broadcaster = Struct.new(:name, :incoming, :dests) do
    def propagate(pulse, origin)
        dests.map { [name, pulse, _1] }
    end
end

modules = input.map do |line|
    name, dests = line.split(" -> ")
    type, name, dests = name[0], name[1..], dests.split(",").map(&:strip)
    case type
    when "b" then ["broadcaster", Broadcaster.new("broadcaster", {}, dests)]
    when "%" then [name, FlipFlop.new(name, {}, dests, false)]
    when "&" then [name, Conjunction.new(name, {}, dests)]
    end
end.to_h
modules.each { |k, m| m.dests.each { |dest| modules[dest].incoming[k] = false if modules[dest] }}

low, high = 0, 0
1000.times do
    q = [["aptly", false, "broadcaster"]]
    until q.empty?
        origin, pulse, dest = q.shift
        pulse ? high += 1 : low += 1
        q += modules[dest]&.propagate(pulse, origin) || []
    end
end

pp low * high