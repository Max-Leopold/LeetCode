extern crate test;

use std::collections::{HashMap, HashSet};
use std::fs::File;
use std::io::{BufRead, BufReader};

pub fn part2() -> Result<usize, Box<dyn std::error::Error>> {
    let file = File::open("input/day9/input.txt")?;
    let reader = BufReader::new(file);

    let dir_map = HashMap::from([("R", [1, 0]), ("L", [-1, 0]), ("U", [0, 1]), ("D", [0, -1])]);

    let mut seen: HashSet<[isize; 2]> = HashSet::new();
    let mut knots = vec![[0, 0]; 10];
    for line in reader.lines() {
        let line = line.unwrap();
        let mut line = line.split_ascii_whitespace();
        let dir = line.next().unwrap();
        let repetitions = line.next().unwrap().parse::<usize>().unwrap();

        for _ in 0..repetitions {
            // Move head
            knots[0] = add_points(knots[0], dir_map[dir]);

            for i in 1..knots.len() {
                let movement = match sub_points(knots[i - 1], knots[i]) {
                    [0, 2] => [0, 1],
                    [1, 2] | [2, 1] | [2, 2] => [1, 1],
                    [2, 0] => [1, 0],
                    [2, -1] | [1, -2] | [2, -2] => [1, -1],
                    [0, -2] => [0, -1],
                    [-1, -2] | [-2, -1] | [-2, -2] => [-1, -1],
                    [-2, 0] => [-1, 0],
                    [-1, 2] | [-2, 1] | [-2, 2] => [-1, 1],
                    _ => [0, 0],
                };
                knots[i] = add_points(knots[i], movement);
            }

            seen.insert(knots[knots.len() - 1]);
        }
    }

    Ok(seen.len())
}

fn add_points(p1: [isize; 2], p2: [isize; 2]) -> [isize; 2] {
    p1.zip(p2).map(|(x, y)| x + y)
}

fn sub_points(p1: [isize; 2], p2: [isize; 2]) -> [isize; 2] {
    p1.zip(p2).map(|(x, y)| x - y)
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part2() {
        assert_eq!(2367, part2().unwrap());
    }

    #[bench]
    fn bench_part2(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }
}
