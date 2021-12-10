input = File.readlines(File.join(File.dirname(__FILE__), "input.txt")).map(&:chomp).map {|line| line.split("")}

def error_score_for_character(char)
    case char
    when ")"
        3
    when "]"
        57
    when "}"
        1197
    when ">"
        25137
    else
        0
    end
end

def completion_score_for_character(char)
    case char
    when "("
        1
    when "["
        2
    when "{"
        3
    when "<"
        4
    else
        0
    end
end

def error_score(parentheses)
    stack = []
    parentheses.each {|parenthesis|
        case parenthesis
        when "(", "[", "{", "<"
            stack.push parenthesis
        else
            to_close = stack.pop
            case to_close
            when "("
                return error_score_for_character(parenthesis) unless parenthesis == ")"
            when "["
                return error_score_for_character(parenthesis) unless parenthesis == "]"
            when "{"
                return error_score_for_character(parenthesis) unless parenthesis == "}"
            when "<"
                return error_score_for_character(parenthesis) unless parenthesis == ">"
            end
        end
    }
    return 0
end

def total_error_score(lines)
    lines.map {|line| 
        error_score = error_score(line)
    }.sum
end

def completion_score(parentheses)
    stack = []
    parentheses.each {|parenthesis|
        case parenthesis
        when "(", "[", "{", "<"
            stack.push parenthesis
        else
            stack.pop
        end
    }
    stack.reverse.inject(0) {|sum, parenthesis|
        sum * 5 + completion_score_for_character(parenthesis)
    }
end

def total_completion_score(lines)
    sorted_completion_scores = lines.select {|line| 
        error_score(line) == 0
    }.map {|line|
        completion_score(line)
    }.sort
    sorted_completion_scores[sorted_completion_scores.length / 2]
end

puts "Day 10, Part 1: Total error score: #{total_error_score(input)}"
puts "Day 10, Part 2: Total completion score: #{total_completion_score(input)}"