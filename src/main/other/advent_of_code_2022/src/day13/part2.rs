use std::fs::File;
use std::io::{BufRead, BufReader};

use super::package::PackageData;

pub fn part2() -> Result<usize, Box<dyn std::error::Error>> {
    let file = File::open("input/day13/input.txt")?;
    let reader = BufReader::new(file);

    let mut packages = vec![
        PackageData::from_chars(&mut "[[2]]".chars()),
        PackageData::from_chars(&mut "[[6]]".chars()),
    ];
    for line in reader.lines() {
        let line = line.unwrap();
        if line.is_empty() {
            continue;
        }
        packages.push(PackageData::from_chars(&mut line.chars()));
    }
    packages.sort();
    Ok((packages
        .binary_search(&PackageData::from_chars(&mut "[[2]]".chars()))
        .unwrap()
        + 1)
        * (packages
            .binary_search(&PackageData::from_chars(&mut "[[6]]".chars()))
            .unwrap()
            + 1))
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part2() {
        assert_eq!(19493, part2().unwrap());
    }

    #[bench]
    fn bench_part2(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }
}
