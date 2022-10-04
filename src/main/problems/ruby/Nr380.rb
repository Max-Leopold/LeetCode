require 'set'

class RandomizedSet
    def initialize()
      @set = Set.new
    end

    def insert(val)
      !!@set.add?(val)
    end

    def remove(val)
      !!@set.delete?(val)
    end

    def get_random()
      @set.to_a.sample
    end
end
