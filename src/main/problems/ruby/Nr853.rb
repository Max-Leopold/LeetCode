# @param {Integer} target
# @param {Integer[]} position
# @param {Integer[]} speed
# @return {Integer}
def car_fleet(target, position, speed)
  sorted = speed.zip(position).each do |x|
    x << ((target - x[1]).to_f / x[0].to_f)
  end.sort_by { |x| -x[1] }

  latest_arrive = -1
  car_fleets = 0
  sorted.each do |speed, pos, arrive|
    if arrive > latest_arrive
      car_fleets += 1
      latest_arrive = arrive
    end
  end

  car_fleets
end

puts car_fleet(
  10,
  [8,3,7,4,6,5],
  [4,4,4,4,4,4]
)
