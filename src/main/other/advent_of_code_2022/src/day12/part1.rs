use std::collections::{HashSet, VecDeque};
use std::fs::File;
use std::io::{BufRead, BufReader};

use itertools::Itertools;

pub fn part1() -> Result<usize, Box<dyn std::error::Error>> {
    let file = File::open("input/day12/input.txt")?;
    let reader = BufReader::new(file);

    let mut matrix = Vec::new();
    for line in reader.lines() {
        let line = line.unwrap();
        let split = line.chars().collect::<Vec<char>>();
        matrix.push(split);
    }

    let rows = matrix.len();
    let cols = matrix[0].len();

    let start = find_pos(&matrix, 'S');
    let end = find_pos(&matrix, 'E');
    matrix[start[0]][start[1]] = 'a';
    matrix[end[0]][end[1]] = 'z';

    let mut seen: HashSet<[usize; 2]> = HashSet::new();
    let mut queue = VecDeque::from([start]);
    while !queue.is_empty() {
        let pos = queue.pop_front().unwrap();
        let mut next_positions = Vec::new();
        if pos[0] > 0 {
            next_positions.push([pos[0] - 1, pos[1], pos[2] + 1])
        }
        if pos[0] < rows - 1 {
            next_positions.push([pos[0] + 1, pos[1], pos[2] + 1])
        }
        if pos[1] > 0 {
            next_positions.push([pos[0], pos[1] - 1, pos[2] + 1])
        }
        if pos[1] < cols - 1 {
            next_positions.push([pos[0], pos[1] + 1, pos[2] + 1])
        }

        for next_position in next_positions {
            if !seen.contains(&next_position[..2])
                && matrix[next_position[0]][next_position[1]] as isize
                    - matrix[pos[0]][pos[1]] as isize
                    <= 1
            {
                if next_position[0] == end[0] && next_position[1] == end[1] {
                    return Ok(next_position[2]);
                } else {
                    queue.push_back(next_position);
                    seen.insert(next_position[..2].try_into().unwrap());
                }
            }
        }
        seen.insert(pos[..2].try_into().unwrap());
    }

    Err("Couldn't find path.".into())
}

fn find_pos(matrix: &Vec<Vec<char>>, search_char: char) -> [usize; 3] {
    let mut iter = matrix.iter().enumerate();
    while let Some((i, row)) = iter.next() {
        if let Some(s) = row.iter().find_position(|c| c == &&search_char) {
            return [i, s.0, 0];
        }
    }

    unreachable!();
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(350, part1().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }
}
