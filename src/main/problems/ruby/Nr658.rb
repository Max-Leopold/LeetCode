# @param {Integer[]} arr
# @param {Integer} k
# @param {Integer} x
# @return {Integer[]}
def find_closest_elements(arr, k, x)
  return arr if k == arr.size

  correct_idx = arr.bsearch_index { |elem| elem >= x }
  left, right = correct_idx - 1, correct_idx
  while right - left + 1 < k
    if left < 0
      right += 1
    elsif right >= arr.size
      left -= 1
    else
      if x - arr[left] <= arr[right] - x
        left -= 1
      else
        right += 1
      end
    end
  end

  arr[left + 1...right]
end

def find_closest_elements(arr, k, x)
  arr[arr.bsearch_index { |elem| x - elem <= (arr[i+k] || 1/0.0) - x }, k]
end

