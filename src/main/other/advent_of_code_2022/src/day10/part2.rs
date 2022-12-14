use std::fs::File;
use std::io::{BufRead, BufReader};

pub fn part2() -> Result<String, Box<dyn std::error::Error>> {
    let file = File::open("input/day10/input.txt")?;
    let reader = BufReader::new(file);

    let mut res = String::from("\n");
    let mut cycle = 0;
    let mut x = 1;
    for line in reader.lines() {
        let line = line.unwrap();
        let mut line = line.split_ascii_whitespace();

        line.next().unwrap();
        let addx = line.next();

        if cycle >= x - 1 && cycle <= x + 1 {
            res.push('#');
        } else {
            res.push('.');
        }
        cycle += 1;
        if cycle >= 40 {
            res.push('\n');
            cycle %= 40;
        }

        match addx {
            Some(addx) => {
                let addx = addx.parse::<isize>().unwrap();
                if cycle >= x - 1 && cycle <= x + 1 {
                    res.push('#');
                } else {
                    res.push('.');
                }
                cycle += 1;
                if cycle >= 40 {
                    res.push('\n');
                    cycle %= 40;
                }
                x += addx;
            }
            None => {}
        }
    }

    Ok(res)
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[bench]
    fn bench_part2(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }
}
