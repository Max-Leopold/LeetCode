# @param {String[]} nums
# @return {String}
def find_different_binary_string(nums)
    sol = ""

    nums.each_with_index do |num, idx|
        sol += num[idx] == "0" ? "1" : "0"
    end

    sol
end