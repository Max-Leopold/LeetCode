# @param {Integer} x
# @return {Boolean}
def is_palindrome(x)
    return false if x < 0
    digits = x.digits
    length = digits.count
    (0..(length / 2)).each { |i|
        return false if digits[i] != digits[length - i - 1]
    }
end