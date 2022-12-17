use std::fs::File;
use std::io::{BufRead, BufReader};

use itertools::Itertools;

use crate::day13::package::PackageData;

pub fn part1() -> Result<usize, Box<dyn std::error::Error>> {
    let file = File::open("input/day13/input.txt")?;
    let reader = BufReader::new(file);

    let mut i = 1;
    let mut res = 0;
    for mut chunk in &reader.lines().chunks(3) {
        let first_package = PackageData::from_chars(&mut chunk.next().unwrap().unwrap().chars());
        let second_package = PackageData::from_chars(&mut chunk.next().unwrap().unwrap().chars());
        if first_package < second_package {
            res += i;
        }
        i += 1;
    }

    Ok(res)
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(6568, part1().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }
}
