class Scanner

    # [x, y, z] rotate 90° around y -> [z, y, -x]
    # [x, y, z] rotate 90° around x -> [x, z, -y]
    # [x, y, z] rotate 90° around z -> [y, -x, z]

    attr_accessor :abs_position, :beacons
    
    def initialize(beacons)
        @beacons = beacons
        @all_rotations = calculate_all_rotations
    end

    def all_rotations
        @all_rotations
    end

    def self.distances_to_point(beacons, px, py, pz)
        beacons.map {|x, y, z|
            Integer.sqrt((px - x) ** 2 + (py - y) ** 2 + (pz - z) ** 2)
        }
    end

    def add_beacons(beacons)
        @beacons = @beacons | beacons
    end

    def self.offset_beacons(beacons, px, py, pz)
        beacons.map do |x, y, z|
            [x + px, y + py, z + pz]
        end
    end

    def self.rotate_90_around_y(beacons)
        beacons.map {|x, y, z|
            [z, y, -x]
        }
    end

    def self.rotate_90_around_x(beacons)
        beacons.map {|x, y, z|
            [x, z, -y]
        }
    end

    def self.rotate_90_around_z(beacons)
        beacons.map {|x, y, z|
            [y, -x, z]
        }
    end

    private

    def calculate_all_rotations
        possible_rotations = []

        operating_beacons = @beacons
        4.times {
            4.times {
                operating_beacons = Scanner.rotate_90_around_y(operating_beacons)
                possible_rotations << operating_beacons
            }
            operating_beacons = Scanner.rotate_90_around_x(operating_beacons)
        }
        operating_beacons = Scanner.rotate_90_around_z(operating_beacons)
        4.times {
            operating_beacons = Scanner.rotate_90_around_y(operating_beacons)
            possible_rotations << operating_beacons
        }
        operating_beacons = Scanner.rotate_90_around_z(operating_beacons)
        operating_beacons = Scanner.rotate_90_around_z(operating_beacons)
        4.times {
            operating_beacons = Scanner.rotate_90_around_y(operating_beacons)
            possible_rotations << operating_beacons
        }
        possible_rotations
    end

end