#![feature(test)]

extern crate test;

mod day1;
mod day2;
mod day3;
mod day4;

fn main() {
    println!("Day 1, Part 1: {}", day1::part1::part1().unwrap());
    println!("Day 1, Part 2: {}", day1::part2::part2().unwrap());

    println!("Day 1, Part 2_2: {}", day1::part2::part2_2().unwrap());
    println!("Day 1, Part 2_3: {}", day1::part2::part2_3().unwrap());

    println!("\n--------------------\n");

    println!("Day 2, Part 1: {}", day2::part1::part1().unwrap());
    println!("Day 2, Part 2: {}", day2::part2::part2().unwrap());

    println!("\n--------------------\n");

    println!("Day 3, Part 1: {}", day3::part1::part1().unwrap());
    println!("Day 3, Part 1_2: {}", day3::part1::part1_2().unwrap());
    println!("Day 3, Part 2: {}", day3::part2::part2().unwrap());

    println!("\n--------------------\n");

    println!("Day 4, Part 1: {}", day4::part1::part1().unwrap());
    println!("Day 4, Part 2: {}", day4::part2::part2().unwrap());
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[bench]
    fn bench_all(b: &mut Bencher) {
        b.iter(|| {
            day1::part1::part1().unwrap();
            day1::part2::part2().unwrap();

            day2::part1::part1().unwrap();
            day2::part2::part2().unwrap();

            day3::part1::part1().unwrap();
            day3::part2::part2().unwrap();

            day4::part1::part1().unwrap();
            day4::part2::part2().unwrap();
        })
    }
}
