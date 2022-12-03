use itertools::Itertools;
use std::collections::HashSet;
use std::fs::File;
use std::io::{BufRead, BufReader};

pub fn part2() -> Result<u32, Box<dyn std::error::Error>> {
    let file = File::open("input/input.txt")?;
    let reader = BufReader::new(file);

    let mut result = 0;
    for lines in &reader.lines().chunks(3) {
        let mut iter = lines
            .into_iter()
            .map(|line| -> HashSet<char> { HashSet::from_iter(line.unwrap().chars()) });

        let badge = iter.next().map(|first_set| {
            iter.fold(first_set, |acc, set| {
                acc.intersection(&set).cloned().collect()
            })
        });
        result += get_priority(*badge.unwrap().iter().next().unwrap());
    }

    Ok(result)
}

fn get_priority(char: char) -> u32 {
    let char = char as u32;

    // "Z" = 90
    if char > 90 {
        // char - "a" + 1
        char - 97 + 1
    } else {
        // char - "A" + 27
        char - 65 + 27
    }
}
