# @param {String} palindrome
# @return {String}
def break_palindrome(palindrome)
  return "" if palindrome.size < 2
  for i in 0...palindrome.size / 2 do
    next if palindrome[i] == 'a'

    palindrome[i] = 'a'
    return palindrome
  end

  palindrome[-1] = 'b'
  palindrome
end
