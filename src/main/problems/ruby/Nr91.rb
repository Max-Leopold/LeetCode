# @param {String} s
# @return {Integer}
def num_decodings(s)
    return 0 if s[0] == '0'
    num_decodings_int(s.to_i, {})
end

def num_decodings_int(i, dp)
    return dp[i] if dp[i]
    return 0 if i == 0
    return 1 if i < 10

    ways = 0
    current_first = i % 10
    i /= 10
    if current_first != 0
        ways += num_decodings_int(i, dp)
    end
    
    current_second = i % 10
    i /= 10
    if current_second != 0 && current_second * 10 + current_first <= 26
        ways += num_decodings_int(i, dp)
    end

    # Revert operations
    i *= 10
    i += current_second
    i *= 10
    i += current_first
    dp[i] = ways
    ways
end