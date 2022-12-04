extern crate test;

use std::fs::File;
use std::io::{BufRead, BufReader};

pub fn part1() -> Result<i32, Box<dyn std::error::Error>> {
    let file = File::open("input/day2/input.txt")?;
    let reader = BufReader::new(file);

    let mut result = 0;
    for line in reader.lines() {
        let line = line.unwrap();
        let selections: Vec<&str> = line.split_whitespace().collect();
        result += selection_points(selections.last().unwrap())
            + result_points(selections.last().unwrap(), selections.first().unwrap())
    }

    Ok(result)
}

fn selection_points(s: &str) -> i32 {
    match s {
        "X" => 1,
        "Y" => 2,
        "Z" => 3,
        _ => panic!("Unsupported choice"),
    }
}

fn result_points(s: &str, o: &str) -> i32 {
    match s {
        "X" => match o {
            "A" => 3,
            "B" => 0,
            "C" => 6,
            _ => panic!("Unsupported choice"),
        },
        "Y" => match o {
            "A" => 6,
            "B" => 3,
            "C" => 0,
            _ => panic!("Unsupported choice"),
        },
        "Z" => match o {
            "A" => 0,
            "B" => 6,
            "C" => 3,
            _ => panic!("Unsupported choice"),
        },
        _ => panic!("Unsupported selection"),
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(11603, part1().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }
}
