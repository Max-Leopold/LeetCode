#![feature(test)]

use std::collections::HashSet;
use std::env;

use getopts::Options;

extern crate test;

mod day1;
mod day2;
mod day3;
mod day4;
mod day5;

fn main() {
    let args: Vec<String> = env::args().collect();
    let program = args[0].clone();

    let mut opts = Options::new();
    opts.optopt(
        "d",
        "days",
        "Comma seperated list of days to run. Leave empty to run all days (default)",
        "DAY",
    );
    opts.optflag("h", "help", "print this help menu");

    let matches = match opts.parse(&args[1..]) {
        Ok(m) => m,
        Err(f) => {
            panic!("{}", f.to_string())
        }
    };
    if matches.opt_present("h") {
        print_usage(&program, opts);
        return;
    }

    let binding = matches.opt_str("d").unwrap_or_default();
    let days = if binding.is_empty() {
        HashSet::<u8>::from_iter(1..25)
    } else {
        let days = binding
            .split(",")
            .map(|str| str.trim().parse::<u8>().unwrap_or_default());
        HashSet::<u8>::from_iter(days)
    };

    print_seperator();

    if days.contains(&1) {
        println!("Day 1, Part 1: {}", day1::part1::part1().unwrap());
        println!("Day 1, Part 2: {}", day1::part2::part2().unwrap());

        println!("Day 1, Part 2_2: {}", day1::part2::part2_2().unwrap());
        println!("Day 1, Part 2_3: {}", day1::part2::part2_3().unwrap());

        print_seperator();
    }

    if days.contains(&2) {
        println!("Day 2, Part 1: {}", day2::part1::part1().unwrap());
        println!("Day 2, Part 2: {}", day2::part2::part2().unwrap());

        print_seperator();
    }

    if days.contains(&3) {
        println!("Day 3, Part 1: {}", day3::part1::part1().unwrap());
        println!("Day 3, Part 1_2: {}", day3::part1::part1_2().unwrap());
        println!("Day 3, Part 2: {}", day3::part2::part2().unwrap());

        print_seperator();
    }

    if days.contains(&4) {
        println!("Day 4, Part 1: {}", day4::part1::part1().unwrap());
        println!("Day 4, Part 2: {}", day4::part2::part2().unwrap());

        print_seperator();
    }

    if days.contains(&5) {
        println!("Day 5, Part 1: {}", day5::part1::part1().unwrap());
        println!("Day 5, Part 2: {}", day5::part2::part2().unwrap());

        print_seperator();
    }
}

fn print_seperator() {
    println!("\n--------------------\n");
}

fn print_usage(program: &str, opts: Options) {
    let brief = format!("Usage: {} [options]", program);
    print!("{}", opts.usage(&brief));
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

            day5::part1::part1().unwrap();
            day5::part2::part2().unwrap();
        })
    }
}
