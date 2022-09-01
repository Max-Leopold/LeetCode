# @param {Integer} n
# @return {Integer}
def climb_stairs(n)
    one_behind = 1
    two_behind = 0
    n.times do 
        two_behind, one_behind = one_behind, one_behind + two_behind
    end
    one_behind
end