input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

result = input.map.each_with_index do |line, i|
    games = line.split(":")
    rounds = games[1].split(";")
    hash = Hash.new(0)
    rounds.each do |round|
        draws = round.split(",")
        draws.each do |draw|
            num, color = draw.strip.split(" ")
            hash[color] = [hash[color], num.to_i].max
        end
    end
    hash.values.inject(1, :*)
end.sum

pp result