#![feature(test)]
#![feature(array_zip)]
#![feature(let_chains)]

use std::collections::HashSet;
use std::env;
use std::time::Instant;

use getopts::Options;

extern crate test;

mod day1;
mod day10;
mod day12;
mod day13;
mod day2;
mod day3;
mod day4;
mod day5;
mod day6;
mod day7;
mod day8;
mod day9;

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

    let now = Instant::now();

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

    if days.contains(&6) {
        println!("Day 6, Part 1: {}", day6::part1::part1().unwrap());
        println!("Day 6, Part 2: {}", day6::part2::part2().unwrap());

        print_seperator();
    }

    if days.contains(&7) {
        println!("Day 7, Part 1: {}", day7::part1::part1().unwrap());
        println!("Day 7, Part 2: {}", day7::part2::part2().unwrap());

        print_seperator();
    }

    if days.contains(&8) {
        println!("Day 8, Part 1: {}", day8::part1::part1().unwrap());
        println!("Day 8, Part 2: {}", day8::part2::part2().unwrap());

        print_seperator();
    }

    if days.contains(&9) {
        println!("Day 9, Part 1: {}", day9::part1::part1().unwrap());
        println!("Day 9, Part 2: {}", day9::part2::part2().unwrap());

        print_seperator();
    }

    if days.contains(&10) {
        println!("Day 10, Part 1: {}", day10::part1::part1().unwrap());
        println!("Day 10, Part 2: {}", day10::part2::part2().unwrap());

        print_seperator();
    }

    if days.contains(&12) {
        println!("Day 12, Part1: {}", day12::part1::part1().unwrap());
        println!("Day 12, Part2: {}", day12::part2::part2().unwrap());

        print_seperator();
    }

    if days.contains(&13) {
        println!("Day 13, Part1: {}", day13::part1::part1().unwrap());
        println!("Day 13, Part2: {}", day13::part2::part2().unwrap());

        print_seperator();
    }

    print_seperator();

    println!("Running this took {}ms", now.elapsed().as_millis());
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

            day6::part1::part1_2().unwrap();
            day6::part2::part2_2().unwrap();

            day7::part1::part1().unwrap();
            day7::part2::part2().unwrap();

            day9::part1::part1().unwrap();
            day9::part2::part2().unwrap();

            day10::part1::part1().unwrap();
            day10::part2::part2().unwrap();

            day12::part1::part1().unwrap();
            day12::part2::part2().unwrap();

            day13::part1::part1().unwrap();
            day13::part2::part2().unwrap();
        })
    }
}
