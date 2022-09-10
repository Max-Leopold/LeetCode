# @param {Integer} m
# @param {Integer} n
# @return {Integer}
def unique_paths(m, n, memo = {})
    return memo[[m, n]] if memo[[m, n]]
    return 1 if m == 1 && n == 1
    return 0 if m <= 0 || n <= 0

    res = unique_paths(m - 1, n, memo) + unique_paths(m, n - 1, memo)
    memo[[m, n]] = res
end