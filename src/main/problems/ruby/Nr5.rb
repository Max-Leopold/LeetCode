# @param {String} s
# @return {String}
def longest_palindrome(s)
    left, right = 0, 0
    (0...s.size).each do |idx|
        expanded_left, expanded_right = expand(s, idx, idx)
        left, right = expanded_left, expanded_right if (expanded_right - expanded_left) > (right - left)
        if idx < s.size - 1
            expanded_left, expanded_right = expand(s, idx + 1, idx)
            left, right = expanded_left, expanded_right if (expanded_right - expanded_left) > (right - left)
        end
    end
    s[left..right]
end

def expand(s, left, right)
    while left > 0 && right < s.size - 1 && s[left - 1] == s[right + 1]
      left -= 1
      right += 1
    end
    return left, right
end