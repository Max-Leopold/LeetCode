require 'set'

class Reactor

    attr_reader :on_cubes

    def initialize
        @on_cubes = Set.new
    end

    def turn_on_cuboid(x, x2, y, y2, z, z2)
        puts "Turn on cuboid x=#{x}..#{x2}, y=#{y}..#{y2}, z=#{z}..#{z2}"
        (x..x2).each {|x|
            (y..y2).each {|y|
                (z..z2).each {|z|
                    @on_cubes.add([x, y, z])
                }
            }
        }
    end

    def turn_off_cuboid(x, x2, y, y2, z, z2)
        puts "Turn off cuboid x=#{x}..#{x2}, y=#{y}..#{y2}, z=#{z}..#{z2}"
        (x..x2).each {|x|
            (y..y2).each {|y|
                (z..z2).each {|z|
                    @on_cubes.delete([x, y, z])
                }
            }
        }
    end

end