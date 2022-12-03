#![feature(test)]

extern crate test;

use part1::part1;
use part2::part2;

mod part1;
mod part2;

fn main() {
    println!("Part 1: {}", part1().unwrap());
    println!("Part 2: {}", part2().unwrap());
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(11603, part1().unwrap());
    }

    #[test]
    fn test_part2() {
        assert_eq!(12725, part2().unwrap());
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
}
