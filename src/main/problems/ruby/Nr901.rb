class StockSpanner

  def initialize()
    @stack = []
    @prices = []
  end

  def next(price)
    while !@stack.empty? && @prices[@stack.last] <= price
      @stack.pop
    end

    res = @prices.size - (@stack.last || -1)
    @stack << @prices.size
    @prices << price
    res
  end
end
