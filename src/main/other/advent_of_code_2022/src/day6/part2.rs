use std::collections::{HashSet, HashMap};
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

pub fn part2_2() -> Result<usize, Box<dyn std::error::Error>> {
  let binding = fs::read_to_string("input/day6/input.txt")?;
  let datastream = binding.trim();
  let lookup = datastream.chars().collect::<Vec<char>>();

  let mut map: HashMap<char, u8> = HashMap::new();
  let mut set: HashSet<char> = HashSet::new();
  let mut i = 0;
  for char in datastream.chars() {
      map.entry(char)
          .and_modify(|counter| *counter += 1)
          .or_insert(1);

      set.insert(char);

      if i >= 14 {
          let remove_char = lookup[i - 14];
          let entry = map.entry(remove_char).and_modify(|counter| *counter -= 1).or_default();
          if *entry == 0 {
            set.remove(&remove_char);
          }
      }

      if set.len() == 14 {
          return Ok(i + 1);
      }

      i += 1;
  }

  panic!("Couldn't find start sequence!");
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part2() {
        assert_eq!(2518, part2().unwrap());
    }

    #[test]
    fn test_part2_2() {
        assert_eq!(2518, part2_2().unwrap());
    }

    #[bench]
    fn bench_part2(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }

    #[bench]
    fn bench_part2_2(b: &mut Bencher) {
        b.iter(|| {
            part2_2().unwrap();
        })
    }
}
