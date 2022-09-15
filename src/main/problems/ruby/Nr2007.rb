# @param {Integer[]} changed
# @return {Integer[]}
def find_original_array(changed)
    return [] unless changed.size % 2 == 0

    res = []
    counts = changed.tally
    changed.sort!
    changed.each do |elem|
        if counts[elem] > 0
            if counts[elem * 2] > 0
                res << elem
                counts[elem * 2] -= 1
            else
                return []
            end
        end
    end

    return res.size == changed.size / 2 ? res : []
end