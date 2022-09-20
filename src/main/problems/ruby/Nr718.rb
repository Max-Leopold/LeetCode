# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Integer}
def find_length(nums1, nums2)
  dp = Array.new(nums1.size) { Array.new(nums2.size) }
  max = 0

  for column in (nums2.size - 1).downto(0)
    for row in (nums1.size - 1).downto(0)
      dp[row][column] = if nums1[row] == nums2[column]
        (dp[row + 1]&.[](column + 1) || 0) + 1
      else
        0
      end
      max = [max, dp[row][column]].max
    end
  end

  max
end
