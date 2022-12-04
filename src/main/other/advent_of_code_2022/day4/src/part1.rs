use std::fs::File;
use std::io::{BufRead, BufReader};

use itertools::Itertools;

use crate::interval::Interval;

pub fn part1() -> Result<u32, Box<dyn std::error::Error>> {
    let file = File::open("input/input.txt")?;
    let reader = BufReader::new(file);

    let mut res = 0;
    for line in reader.lines() {
        let line = line.unwrap();
        let (first, second) = line
            .split(',')
            .map(|str| Interval::from_string(str))
            .next_tuple()
            .unwrap();

        if first.contains_fully(&second) || second.contains_fully(&first) {
            res += 1
        }
    }

    Ok(res)
}
