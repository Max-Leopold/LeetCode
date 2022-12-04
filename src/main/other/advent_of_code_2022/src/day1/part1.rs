extern crate test;

use std::fs::File;
use std::io::{BufRead, BufReader};

pub fn part1() -> std::io::Result<i32> {
    let file = File::open("input/day1/input.txt")?;
    let reader = BufReader::new(file);

    let mut result = 0;
    let mut current_calories = 0;
    for line in reader.lines() {
        match line.unwrap_or_default().parse::<i32>() {
            Ok(calories) => {
                current_calories += calories;
            }
            Err(_) => {
                result = std::cmp::max(result, current_calories);
                current_calories = 0;
            }
        }
    }

    Ok(std::cmp::max(result, current_calories))
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(69289, part1().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }
}
