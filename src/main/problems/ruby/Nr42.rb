# @param {Integer[]} height
# @return {Integer}
def trap(height)
  trapped = 0
  left, right = 0, height.size - 1
  max_left_height = height[left]
  max_right_height = height[right]
  while left < right
    if max_left_height < max_right_height # Move left
      left += 1
      if height[left] < max_left_height
        trapped += max_left_height - height[left]
      else
        max_left_height = height[left]
      end
    else # Move right
      right -= 1
      if height[right] < max_right_height
        trapped += max_right_height - height[right]
      else
        max_right_height = height[right]
      end
    end
  end

  trapped
end
