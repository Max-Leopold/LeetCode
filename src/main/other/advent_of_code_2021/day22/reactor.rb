require 'set'

class Reactor

    def initialize
        @cuboids = Set.new
    end

    def turn_on_cuboid(new_cuboid)
        new_cuboids = [new_cuboid]
        @cuboids.each {|cuboid|
            new_cuboids = new_cuboids.map {|new_cuboid|
                shared_cuboid = Reactor.shared_cuboid(cuboid, new_cuboid)
                # Has intesection
                if shared_cuboid[0] < shared_cuboid[1] && shared_cuboid[2] < shared_cuboid[3] && shared_cuboid[4] < shared_cuboid[5]
                    # Split and only use non intersecting cuboids
                    Reactor.split_and_remove_cuboid(new_cuboid, shared_cuboid)
                else
                    [new_cuboid]
                end
            }.flatten(1)
        }
        @cuboids = @cuboids.merge(new_cuboids)
    end

    def turn_off_cuboid(remove_cuboid)
        new_cuboids = []
        @cuboids.delete_if {|cuboid|
            shared_cuboid = Reactor.shared_cuboid(cuboid, remove_cuboid)
            # Has intersection
            if shared_cuboid[0] < shared_cuboid[1] && shared_cuboid[2] < shared_cuboid[3] && shared_cuboid[4] < shared_cuboid[5]
                # Split cuboid and add all parts that don't overlap to cuboids
                new_cuboids += Reactor.split_and_remove_cuboid(cuboid, shared_cuboid)
                true
            else
                false
            end
        }
        @cuboids = @cuboids.merge(new_cuboids)
    end

    def total_lights_on
        lights_on = 0
        @cuboids.map {|x, x2, y, y2, z, z2|
            (x2 - x) * (y2 - y) * (z2 - z)
        }.sum
    end

    def self.shared_cuboid(cuboid1, cuboid2)
        x, x2, y, y2, z, z2 = *cuboid1
        a, a2, b, b2, c, c2 = *cuboid2

        sx, sx2 = [a, x].max, [a2, x2].min
        sy, sy2 = [b, y].max, [b2, y2].min
        sz, sz2 = [c, z].max, [c2, z2].min

        return sx, sx2, sy, sy2, sz, sz2
    end

    def self.split_and_remove_cuboid(cuboid1, cuboid_to_remove)
        x, x2, y, y2, z, z2 = *cuboid1
        a, a2, b, b2, c, c2 = *cuboid_to_remove

        # Split cuboid into 27 smaller cuboids
        Reactor.remove_planes [
            [x, a, y, b, z, c],
            [x, a, y, b, c, c2],
            [x, a, y, b, c2, z2],
            [x, a, b, b2, z, c],
            [x, a, b, b2, c, c2],
            [x, a, b, b2, c2, z2],
            [x, a, b2, y2, z, c],
            [x, a, b2, y2, c, c2],
            [x, a, b2, y2, c2, z2],
            # ---
            [a, a2, y, b, z, c],
            [a, a2, y, b, c, c2],
            [a, a2, y, b, c2, z2],
            [a, a2, b, b2, z, c],
            [a, a2, b, b2, c, c2],
            [a, a2, b, b2, c2, z2],
            [a, a2, b2, y2, z, c],
            [a, a2, b2, y2, c, c2],
            [a, a2, b2, y2, c2, z2],
            # ---
            [a2, x2, y, b, z, c],
            [a2, x2, y, b, c, c2],
            [a2, x2, y, b, c2, z2],
            [a2, x2, b, b2, z, c],
            [a2, x2, b, b2, c, c2],
            [a2, x2, b, b2, c2, z2],
            [a2, x2, b2, y2, z, c],
            [a2, x2, b2, y2, c, c2],
            [a2, x2, b2, y2, c2, z2],
        ] - [cuboid_to_remove]
    end

    def self.remove_planes(cuboids)
        cuboids.select {|x, x2, y, y2, z, z2|
            x != x2 && y != y2 && z != z2
        }
    end
end