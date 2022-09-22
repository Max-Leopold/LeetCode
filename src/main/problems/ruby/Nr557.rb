# @param {String} s
# @return {String}
def reverse_words(s)
    s.split(" ").map(&:reverse).join(" ")
end

def reverse_words(s)
    start_idx = 0
    end_idx = 0
    while end_idx < s.size - 1
        if s[end_idx + 1] == " "
            reverse_range(s, start_idx, end_idx)
            start_idx = end_idx + 1
        end
        end_idx += 2
    end
    reverse_range(start_idx, end_idx)
    s
end

def reverse_range(s, start_idx, end_idx)
    while start_idx < end_idx
        puts s[start_idx], s[end_idx]
        s[start_idx], s[end_idx] = s[end_idx], s[start_idx]
        start_idx += 1
        end_idx -=1
    end
end