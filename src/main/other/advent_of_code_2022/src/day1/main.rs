#![feature(test)]

extern crate test;

use std::fs::File;
use std::io::{BufRead, BufReader};

fn main() {
    println!("Day 1, Part 1: {}", part1().unwrap());
    println!("Day 2, Part 2: {}", part2().unwrap());

    println!("Day 2, Part 2_2: {}", part2_2().unwrap());
    println!("Day 2, Part 2_3: {}", part2_3().unwrap());
}

fn part1() -> std::io::Result<i32> {
    let file = File::open("input/input.txt")?;
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

// Sort array at end and sum three biggest elems
fn part2() -> std::io::Result<i32> {
    let file = File::open("input/input.txt")?;
    let reader = BufReader::new(file);

    let mut current_calories = 0;
    let mut elves = Vec::new();
    for line in reader.lines() {
        match line.unwrap_or_default().parse::<i32>() {
            Ok(calories) => {
                current_calories += calories;
            }
            Err(_) => {
                elves.push(current_calories);
                current_calories = 0;
            }
        }
    }

    elves.sort_by(|a, b| b.cmp(a));
    Ok(elves[..3].iter().sum())
}

// Sort array as soon as we have 4 elements and remove the smallest
fn part2_2() -> std::io::Result<i32> {
    let file = File::open("input/input.txt")?;
    let reader = BufReader::new(file);

    let mut current_calories = 0;
    let mut elves = Vec::new();
    for line in reader.lines() {
        match line.unwrap_or_default().parse::<i32>() {
            Ok(calories) => {
                current_calories += calories;
            }
            Err(_) => {
                elves.push(current_calories);
                if elves.len() > 3 {
                    elves.sort_by(|a, b| b.cmp(a));
                    elves = elves[0..3].to_vec();
                }
                current_calories = 0;
            }
        }
    }

    Ok(elves.iter().sum())
}

fn part2_3() -> std::io::Result<i32> {
    let file = File::open("input/input.txt")?;
    let reader = BufReader::new(file);

    let mut current_calories = 0;
    let mut elves = Vec::new();
    for line in reader.lines() {
        match line.unwrap_or_default().parse::<i32>() {
            Ok(calories) => {
                current_calories += calories;
            }
            Err(_) => {
                elves.push(current_calories);
                current_calories = 0;
            }
        }
    }

    let mut sum = 0;
    for _ in 0..3 {
        sum += find_and_remove_max(&mut elves);
    }

    Ok(sum)
}

fn find_and_remove_max(v: &mut Vec<i32>) -> i32 {
    let (index, max) = v
        .iter()
        .enumerate()
        .max_by(|(_, a), (_, b)| a.cmp(b))
        .unwrap();

    let max = max.clone();

    v[index] = 0;
    max
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(69289, part1().unwrap());
    }

    #[test]
    fn test_part2() {
        assert_eq!(205615, part2().unwrap());
    }

    #[test]
    fn test_part2_2() {
        assert_eq!(205615, part2_2().unwrap());
    }

    #[test]
    fn test_part2_3() {
        assert_eq!(205615, part2_3().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }

    #[bench]
    fn bench_part2(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }

    #[bench]
    fn bench_part2_2(b: &mut Bencher) {
        b.iter(|| {
            part2_2().unwrap();
        })
    }

    #[bench]
    fn bench_part2_3(b: &mut Bencher) {
        b.iter(|| {
            part2_3().unwrap();
        })
    }
}
