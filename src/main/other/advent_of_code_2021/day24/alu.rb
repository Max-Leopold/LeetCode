class String
    def is_integer?
        self.to_i.to_s == self
    end
end

class Variable

    attr_accessor :value

    def initialize
        @value = 0
    end

    def add(other)
        if other.is_a? Variable
            @value += other.value
        else
            @value += other
        end
        self
    end

    def mul(other)
        if other.is_a? Variable
            @value *= other.value
        else
            @value *= other
        end
        self
    end

    def div(other)
        if other.is_a? Variable
            @value /= other.value
        else
            @value /= other
        end
        self
    end

    def mod(other)
        if other.is_a? Variable
            @value %= other.value
        else
            @value %= other
        end
        self
    end

    def same(other)
        if other.is_a? Variable
            @value = @value == other.value ? 1 : 0
        else
            @value = @value == other ? 1 : 0
        end
        self
    end
end

class Alu

    def self.monad(instructions, number)
        inputs = number.digits.reverse
        input_index = 0

        variables = {"w" => Variable.new, "x" => Variable.new, "y" => Variable.new, "z" => Variable.new}
        instructions.each {|instruction|
            instruction, variable1, variable2 = instruction.chomp.split(" ")
            variable1 = variables[variable1]
            unless variable2.nil?
                variable2 = variable2.is_integer? ? variable2.to_i : variables[variable2]
            end
            case instruction
            when "inp"
                variable1.value = inputs[input_index]
                input_index += 1
            when "add"
                variable1.add variable2
            when "mul"
                variable1.mul variable2
            when "div"
                variable1.div variable2 
            when "mod"
                variable1.mod variable2
            when "eql"
                variable1.same variable2
            end
        }
        variables
    end
end