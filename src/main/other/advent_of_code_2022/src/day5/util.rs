extern crate test;

use std::collections::VecDeque;
use std::fs::File;
use std::io::{BufRead, BufReader};

use itertools::Itertools;

pub fn get_initial_crates() -> Result<Vec<VecDeque<char>>, Box<dyn std::error::Error>> {
    let mut crate_stacks: Vec<VecDeque<char>> = Vec::new();

    let crate_file = File::open("input/day5/crates.txt")?;
    let reader = BufReader::new(crate_file);

    // Read boxes
    for line in reader.lines() {
        let line = line.unwrap();

        let mut index = 0;
        for mut chunk in &line.chars().chunks(4) {
            if crate_stacks.len() <= index {
                crate_stacks.push(VecDeque::new());
            }
            if chunk.next() == Some('[') {
                crate_stacks
                    .get_mut(index)
                    .unwrap()
                    .push_back(chunk.next().unwrap());
            }
            index += 1;
        }
    }

    return Ok(crate_stacks);
}

pub fn create_crates_string(crates: &Vec<VecDeque<char>>) -> String {
    crates
        .iter()
        .map(|stack| stack.front().unwrap_or(&' '))
        .collect::<String>()
}
