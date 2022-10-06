class TimeMap
  def initialize()
    @map = Hash.new
  end

  def set(key, value, timestamp)
    @map[key] ||= []
    @map[key] << [timestamp, value]
  end

  def get(key, timestamp)
    return "" unless @map.key?(key)

    index = @map[key].bsearch_index { |x| x[0] > timestamp }
    if !index
      @map[key][-1][1]
    elsif index == 0
      ""
    else
      @map[key][index - 1][1]
    end
  end
end
