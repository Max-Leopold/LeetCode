# @param {Integer[][]} intervals
# @param {Integer[]} new_interval
# @return {Integer[][]}
# Runtime: O(n^2) (Because delete_at takes O(n)), Space: O(1)
def insert(intervals, new_interval)
    return [new_interval] if intervals.nil? || intervals.size == 0

    insert_pos = intervals.bsearch_index { |x| x[0] > new_interval[0] } || intervals.size
    intervals.insert(insert_pos, new_interval)

    idx = 0
    while idx < intervals.size - 1
        idx += 1 unless merge(intervals, idx, idx + 1)
    end

    intervals
end

def merge(intervals, first, second)
    if intervals[first][1] >= intervals[second][0]
        _, new_end = intervals.delete_at(second)
        intervals[first][1] = [new_end, intervals[first][1]].max
        return true
    end
    false
end

# Runtime: O(n), Space: O(n)
def insert(intervals, new_interval)
    left, right = [], []
    intervals.each do |i_start, i_end|
        # Left
        if i_end < new_interval[0]
            left << [i_start, i_end]
        # Right
        elsif i_start > new_interval[1]
            right << [i_start, i_end]
        elsif 
            new_interval[0] = [new_interval[0], i_start].min
            new_interval[1] = [new_interval[1], i_end].max
        end
    end

    left + [new_interval] + right
end

pp insert(
    [[1,2],[3,5],[6,7],[8,10],[12,16]],
    [4,8]
)