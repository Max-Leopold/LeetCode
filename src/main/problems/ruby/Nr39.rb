# @param {Integer[]} candidates
# @param {Integer} target
# @return {Integer[][]}
def combination_sum(candidates, target, current_sum = 0, current = [], start = 0)
    return [current.dup] if current_sum == target
    return nil if current_sum > target
    return nil if start >= candidates.size

    # Take current
    current << candidates[start]
    res_take = combination_sum(
        candidates, 
        target, 
        current_sum + candidates[start], 
        current,
        start
    )
    current.pop

    # Skip current
    res_skip = combination_sum(
        candidates,
        target,
        current_sum,
        current,
        start + 1
    )

    (res_take || []) + (res_skip || [])
end