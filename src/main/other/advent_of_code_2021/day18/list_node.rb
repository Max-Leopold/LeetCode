class ListNode
    include Enumerable

    attr_accessor :next, :prev, :value, :depth, :parent

    def each(&block)
        yield self
        self.next.each(&block) unless self.next.nil?
    end

    def to_s
        @value.to_s
    end

    def to_list_s
        current_value = "#@value (depth: #@depth, prev #@prev) -> "
        next_value = @next.nil? ? "" : @next.to_list_s
        current_value + next_value
    end
    
end