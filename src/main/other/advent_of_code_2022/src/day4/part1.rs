extern crate test;

use std::fs::File;
use std::io::{BufRead, BufReader};

use itertools::Itertools;

use crate::day4::interval::Interval;

pub fn part1() -> Result<u32, Box<dyn std::error::Error>> {
    let file = File::open("input/day4/input.txt")?;
    let reader = BufReader::new(file);

    let mut res = 0;
    for line in reader.lines() {
        let line = line.unwrap();
        let (first, second) = line
            .split(',')
            .map(|str| Interval::from_string(str))
            .next_tuple()
            .unwrap();

        if first.contains_fully(&second) || second.contains_fully(&first) {
            res += 1
        }
    }

    Ok(res)
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(462, part1().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }
}
