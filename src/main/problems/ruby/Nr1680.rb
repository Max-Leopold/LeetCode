# @param {Integer} n
# @return {Integer}
def concatenated_binary(n)
    (1..n).map { |num| num.to_s(2) }.join.to_i(2) % (10 ** 9 + 7)
end

def concatenated_binary(n)
    res = 0
    mod = 10 ** 9 + 7
    (1..n).each do |num|
        res = (res << num.bit_length | num) % mod
    end
    res
end