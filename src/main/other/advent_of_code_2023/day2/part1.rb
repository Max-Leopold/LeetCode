input = File.open(File.join(File.dirname(__FILE__), "input.txt"), "r").map(&:chomp)

max_cubes = {
    "red" => 12,
    "green" => 13,
    "blue" => 14
}

result = input.map.each_with_index do |line, i|
    games = line.split(":")
    rounds = games[1].split(";")
    rounds.any? do |round|
        draws = round.split(",")
        draws.any? do |draw|
            num, color = draw.strip.split(" ")
            num.to_i > max_cubes[color]
        end
    end ? 0 : i + 1
end.sum

pp result