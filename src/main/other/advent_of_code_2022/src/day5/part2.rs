extern crate test;

use std::collections::VecDeque;
use std::fs::File;
use std::io::{BufRead, BufReader};

use itertools::Itertools;

use super::util;

pub fn part2() -> Result<String, Box<dyn std::error::Error>> {
    let mut crate_stacks = util::get_initial_crates().unwrap();

    let move_file = File::open("input/day5/moves.txt")?;
    let reader = BufReader::new(move_file);

    for line in reader.lines() {
        let line = line.unwrap();

        let move_data = &line
            .split_whitespace()
            .chunks(2)
            .into_iter()
            .map(|chunk| chunk.last().unwrap().parse::<usize>().unwrap())
            .collect::<Vec<usize>>();

        move_crates(
            &mut crate_stacks,
            *move_data.get(0).unwrap(),
            *move_data.get(1).unwrap() - 1,
            *move_data.get(2).unwrap() - 1,
        )
    }

    Ok(util::create_crates_string(&crate_stacks))
}

fn move_crates(crates: &mut Vec<VecDeque<char>>, n: usize, from: usize, to: usize) {
    let drained_crates = crates
        .get_mut(from)
        .unwrap()
        .drain(..n)
        .rev()
        .collect::<Vec<char>>();
    let to = crates.get_mut(to).unwrap();
    for drained_crate in drained_crates {
        to.push_front(drained_crate);
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part2() {
        assert_eq!("GSLCMFBRP", part2().unwrap());
    }

    #[bench]
    fn bench_part2(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }
}
