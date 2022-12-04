extern crate test;

use std::fs::File;
use std::io::{BufRead, BufReader};

use itertools::Itertools;

use crate::day4::interval::Interval;

pub fn part2() -> Result<u32, Box<dyn std::error::Error>> {
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

        if first.contains_part(&second) {
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
    fn test_part2() {
        assert_eq!(835, part2().unwrap());
    }

    #[bench]
    fn bench_part2(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }
}
