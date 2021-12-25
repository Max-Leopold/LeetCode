IMG_ALGORITHM = File.open(File.join(File.dirname(__FILE__), "img_algo.txt"), &:readline).chomp.split("")

def pad_image(image)
    new_image = Array.new(image.length + 4) {Array.new(image[0].length + 4, false)}
    image.each.with_index {|row, i|
        row.each.with_index {|pixel, j|
            if pixel == "#"
                new_image[i + 2][j + 2] = true
            end
        }
    }
    new_image
end

def set_border(image, light)
    image.each.with_index {|row, i|
        row.each.with_index{|pixel, j|
            if (i < 3 || i >= image.length - 3 || j < 3 || j >= image[i].length - 3)
                image[i][j] = light
            end
        }
    }
end

def enhancePixelGrid(pixels)
    binary_string = pixels.map do |pixel|
        case pixel
        when false
            0
        when true
            1
        end
    end.join
    index = binary_string.to_i(2)
    IMG_ALGORITHM[index] == "#"
end

def enhance(image)
    new_image = Array.new(image.length + 4) {Array.new(image[0].length + 4, false)}
    row = 1
    while row < image.length - 1
        column = 1
        while column < image[row].length - 1
            pixel_grid = image[row - 1][(column - 1)..(column + 1)] + image[row][(column - 1)..(column + 1)] + image[row + 1][(column - 1)..(column + 1)]
            new_image[row + 2][column + 2] = enhancePixelGrid(pixel_grid)
            column += 1
        end
        row += 1
    end
    if image[0][0]
        set_border(new_image, IMG_ALGORITHM.last == "#")
    else
        set_border(new_image, IMG_ALGORITHM.first == "#")
    end
    new_image
end

def print_image(image)
    image.each {|row|
        row.each{|pixel|
            case pixel
            when true
                print "#"
            else
                print "."
            end
        }
        puts
    }
    puts
end

initial_image = pad_image(File.open(File.join(File.dirname(__FILE__), "image.txt"), "r").map {|line| line.chomp.split("")})

2.times {
    initial_image = enhance(initial_image)
}

puts "Day 20, Part 1: After enhancing the image 2 times there are #{initial_image.map {|row| row.select {|pixel| pixel == true}.count}.sum} pixels lit"

48.times {
    initial_image = enhance(initial_image)
}

puts "Day 20, Part 1: After enhancing the image 50 times there are #{initial_image.map {|row| row.select {|pixel| pixel == true}.count}.sum} pixels lit"