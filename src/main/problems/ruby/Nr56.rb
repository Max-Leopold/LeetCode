# @param {Integer[][]} intervals
# @return {Integer[][]}
def merge(intervals)
    intervals.sort! { |a, b| a[0] <=> b[0] }

    res = [intervals[0]]
    intervals.each do |i_start, i_end|
        last_start, last_end = res.last
        if i_start <= last_end
            res[res.size - 1] = [
                [last_start, i_start].min,
                [last_end, i_end].max
            ]
        else
            res << [i_start, i_end]
        end
    end

    res
end