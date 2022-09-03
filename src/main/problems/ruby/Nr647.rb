# @param {String} s
# @return {Integer}
def count_substrings(s)
    total_count = 0
    (0...s.size).each do |idx|
        total_count += expand(s, idx, idx)
        total_count += expand(s, idx - 1, idx)
    end
    total_count
end

def expand(s, start, end_idx)
    count = 0
    while start >= 0 && end_idx < s.size && s[start] == s[end_idx]
        start -= 1
        end_idx += 1
        count += 1
    end
    count
end