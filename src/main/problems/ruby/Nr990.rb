# @param {String[]} equations
# @return {Boolean}
def equations_possible(equations)
  node = Struct.new(:val) do
    attr_accessor :parent, :size

    def initialize(val)
      @parent = self
      @size = 1
      super
    end

    def find_parent
      current_parent = self
      while current_parent != current_parent.parent
        current_parent = current_parent.parent
      end
      current_parent
    end
  end
  map = {}

  equations.each do |eq|
    var1, var2 = eq[0], eq[3]
    map[var1] ||= node.new(var1)
    map[var2] ||= node.new(var2)
  end

  equations.each do |eq|
    next if eq[1] == '!'

    node1, node2 = map[eq[0]], map[eq[3]]

    if node1.size < node2.size
      node1.find_parent.parent = node2.find_parent
      node1.size += node2.size
    else
      node2.find_parent.parent = node1.find_parent
      node2.size += node1.size
    end
  end

  equations.each do |eq|
    next if eq[1] == '='

    return false if map[eq[0]].find_parent == map[eq[3]].find_parent
  end

  true
end
