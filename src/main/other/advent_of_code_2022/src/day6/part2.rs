use std::collections::HashSet;
use std::fs;

extern crate test;

pub fn part2() -> Result<u32, Box<dyn std::error::Error>> {
    let binding = fs::read_to_string("input/day6/input.txt")?;
    let datastream = binding.trim();

    let mut i = 14;
    for window in datastream.chars().collect::<Vec<char>>().windows(14) {
        let mut set = HashSet::new();
        for char in window {
            if set.contains(char) {
              i += 1;
              break;
            }
            set.insert(char);
        }
        if set.len() == 14 {
          return Ok(i);
        }
    }

    panic!("Couldn't find start sequence!");
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(2518, part2().unwrap());
    }

    #[bench]
    fn bench_part2(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }
}
