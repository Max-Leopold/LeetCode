extern crate test;

use std::fs::File;
use std::io::{BufRead, BufReader};

pub fn part1() -> Result<isize, Box<dyn std::error::Error>> {
    let file = File::open("input/day10/input.txt")?;
    let reader = BufReader::new(file);

    let mut res = 0;
    let mut cycle = 0;
    let mut x = 1;
    for line in reader.lines() {
        let line = line.unwrap();
        let mut line = line.split_ascii_whitespace();

        line.next().unwrap();
        let addx = line.next();

        cycle += 1;
        if cycle == 20 || (cycle - 20) % 40 == 0 {
            res += cycle * x;
        }

        match addx {
            Some(addx) => {
                let addx = addx.parse::<isize>().unwrap();
                cycle += 1;
                if cycle == 20 || (cycle - 20) % 40 == 0 {
                    res += cycle * x;
                }
                x += addx;
            }
            None => {}
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
        assert_eq!(13180, part1().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }
}
