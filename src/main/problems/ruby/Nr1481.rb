# @param {Integer[]} arr
# @param {Integer} k
# @return {Integer}
def find_least_num_of_unique_ints(arr, k)
    counts = arr.tally
    counts.values.sort.select do |num|
        next true if num > k

        k -= num
        false
    end.size
end

puts find_least_num_of_unique_ints([5,5,4], 1)