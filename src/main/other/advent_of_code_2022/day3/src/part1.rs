use std::collections::HashSet;
use std::fs::File;
use std::io::{BufRead, BufReader};

pub fn part1() -> Result<u32, Box<dyn std::error::Error>> {
    let file = File::open("input/input.txt")?;
    let reader = BufReader::new(file);

    let mut result = 0;
    for line in reader.lines() {
        let line = line.unwrap();
        let firt_rucksack = &line[..line.len() / 2];
        let second_rucksack = &line[line.len() / 2..];

        let mut set = HashSet::new();
        set.extend(firt_rucksack.chars());

        let duplicate_item = second_rucksack.chars().find(|&x| set.contains(&x));
        result += get_priority(duplicate_item.unwrap());
    }

    Ok(result)
}

pub fn part1_2() -> Result<u32, Box<dyn std::error::Error>> {
    let file = File::open("input/input.txt")?;
    let reader = BufReader::new(file);

    let mut result = 0;
    for line in reader.lines() {
        let line = line.unwrap();
        let firt_rucksack = &line[..line.len() / 2];
        let second_rucksack = &line[line.len() / 2..];
        println!("{}", firt_rucksack);
        println!("{}", second_rucksack);

        let mut first_rucksack_set = HashSet::new();
        let mut second_rucksack_set = HashSet::new();
        first_rucksack_set.extend(firt_rucksack.chars());
        second_rucksack_set.extend(second_rucksack.chars());

        let duplicate_item = first_rucksack_set.intersection(&second_rucksack_set).next();
        result += get_priority(*duplicate_item.unwrap());
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
