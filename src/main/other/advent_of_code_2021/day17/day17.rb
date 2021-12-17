# ---------- Input ----------
x_min = 230
x_max = 283

y_min = -107
y_max = -57
# ---------------------------

def calculate_next_point(x, y, x_vel, y_vel)
    return x + x_vel, y + y_vel, [x_vel - 1, 0].max, y_vel - 1
end

def trajectory_hits_box?(x_range, y_range, x_vel, y_vel)
    x = 0
    y = 0
    until x_range.last < x || y_range.first > y  || (x_range.member?(x) && y_range.member?(y))
        x, y, x_vel, y_vel = calculate_next_point(x, y, x_vel, y_vel)
    end
    return x_range.member?(x) && y_range.member?(y)
end

def calculate_trajectories(x_min, x_max, y_min, y_max)
    x_range = (x_min..x_max)
    y_range = (y_min..y_max)

    best_y = 0
    hit_target = 0

    (0..x_max).each { |x_vel|
        (y_min..y_min.abs).each { |y_vel|
            if trajectory_hits_box?(x_range, y_range, x_vel, y_vel)
                best_y = [best_y, y_vel].max
                hit_target += 1
            end
        }
    }
    return (0..best_y).sum, hit_target
end

highest_y_trajectory, tranjectories_hitting_target = calculate_trajectories(x_min, x_max, y_min, y_max)
puts "Day 17, Part 1: The best trickshot still hitting the trench reaches a height of #{highest_y_trajectory}"
puts "Day 17, Part 2: In total #{tranjectories_hitting_target} trajectories are hitting the target"