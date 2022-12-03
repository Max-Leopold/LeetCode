use std::fs::File;
use std::io::{BufRead, BufReader};

pub fn part2() -> Result<i32, Box<dyn std::error::Error>> {
    let file = File::open("input/input.txt")?;
    let reader = BufReader::new(file);

    let mut result = 0;
    for line in reader.lines() {
        let line = line.unwrap();
        let selections: Vec<&str> = line.split_whitespace().collect();
        let (selection, round_points) =
            choose_selection(selections.first().unwrap(), selections.last().unwrap());
        result += round_points + selection_points(selection);
    }
    Ok(result)
}

fn selection_points(selection: &str) -> i32 {
    match selection {
        "A" => 1,
        "B" => 2,
        "C" => 3,
        _ => panic!("Unsupported choice"),
    }
}

fn choose_selection<'a>(opponent: &'a str, result: &'a str) -> (&'a str, i32) {
    match result {
        "X" => match opponent {
            "A" => ("C", 0),
            "B" => ("A", 0),
            "C" => ("B", 0),
            _ => panic!("Unsupported choice"),
        },
        "Y" => (opponent, 3),
        "Z" => match opponent {
            "A" => ("B", 6),
            "B" => ("C", 6),
            "C" => ("A", 6),
            _ => panic!("Unsupported choice"),
        },
        _ => panic!("Unsupported choice"),
    }
}
