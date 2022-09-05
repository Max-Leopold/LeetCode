# @param {Integer[]} coins
# @param {Integer} amount
# @return {Integer}
def coin_change(coins, amount)
    dp = [0]
    (0..amount).each do |curr_amount|
        coins.each do |curr_coin|
            if curr_amount +  curr_coin <= amount && dp[curr_amount]
                dp[curr_amount +  curr_coin] = dp[curr_amount +  curr_coin].nil? ? dp[curr_amount] + 1 : [dp[curr_amount] + 1, dp[curr_amount +  curr_coin]].min
            end
        end
    end
    dp[amount] || -1
end