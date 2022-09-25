class MyCircularQueue
  def initialize(k)
    @queue = Array.new(k)
    @front = 0
    @back = 0
  end

  def en_queue(value)
    return false if is_full

    @back = (@back + 1) % @queue.size if @queue[@front]
    @front = @back if @queue[@front].nil?
    @queue[@back] = value

    true
  end

  def de_queue()
    return false if is_empty

    @queue[@front] = nil
    @front = (@front + 1) % @queue.size
    @back = @front if @queue[@back].nil?

    true
  end

  def front()
    return -1 if is_empty

    @queue[@front]
  end

  def rear()
    return -1 if is_empty

    @queue[@back]
  end

  def is_empty()
    @queue[@front].nil?
  end

  def is_full()
    (@back + 1) % @queue.size == @front && @queue[@front]
  end
end
