# https://codingdojo.org/kata/Diamond/

def print_diamond(end_char, current_char = 'A')
    return if end_char.ord - 'A'.ord >= 26

    size = (end_char.ord - 'A'.ord) * 2 + 1
    string = " " * size
    pos = current_char.ord - 'A'.ord
    string[(size / 2) + pos] = current_char
    string[(size / 2) - pos] = current_char

    puts string
    return if end_char == current_char
    print_diamond(end_char, current_char.next)
    puts string
end

print_diamond('Z')