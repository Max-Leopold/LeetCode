#![feature(test)]

extern crate test;

mod part1;
mod part2;

use crate::part1::part1;
use crate::part2::part2;

fn main() {
    println!("Part 1: {}", part1().unwrap());
    println!("Part 2: {}", part2().unwrap());
}

#[cfg(test)]
mod tests {
    use crate::part1::part1_2;

    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(7863, part1().unwrap());
    }

    #[test]
    fn test_part1_2() {
        assert_eq!(7863, part1_2().unwrap());
    }

    #[test]
    fn test_part2() {
        assert_eq!(2488, part2().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }

    #[bench]
    fn bench_part1_2(b: &mut Bencher) {
        b.iter(|| {
            part1_2().unwrap();
        })
    }

    #[bench]
    fn bench_part2(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }
}
