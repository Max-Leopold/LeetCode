# @param {Integer[][]} intervals
# @return {Integer}
def erase_overlap_intervals(intervals)
    intervals.sort_by! { |a| a[0] }

    overlaps = 0
    i_end = intervals[0][1]

    for idx in 1...intervals.size
        if intervals[idx][0] < i_end
            overlaps += 1
            i_end = [i_end, intervals[idx][1]].min
        else
            i_end = intervals[idx][1]
        end
    end

    overlaps
end