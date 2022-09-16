# @param {Integer[]} tokens
# @param {Integer} power
# @return {Integer}
def bag_of_tokens_score(tokens, power)
    tokens.sort!
    max_score, current_score = 0, 0
    left, right = 0, tokens.size - 1
    while left <= right
        return max_score if current_score == 0 && power < tokens[left]

        # Get score
        if power >= tokens[left]
            current_score += 1
            power -= tokens[left]

            left += 1
        else
            current_score -= 1
            power += tokens[right]

            right -= 1
        end

        max_score = [max_score, current_score].max
    end

    max_score
end
