use std::fs::File;
use std::io::{BufRead, BufReader};

pub fn part1() -> Result<usize, Box<dyn std::error::Error>> {
    let file = File::open("input/day8/input.txt")?;
    let reader = BufReader::new(file);

    let mut trees: Vec<i8> = Vec::new();
    let mut rows: usize = 0;
    for line in reader.lines() {
        let line = line.unwrap();
        trees.extend(
            line.split_inclusive("")
                .skip(1)
                .map(|x| x.parse::<i8>().unwrap()),
        );
        rows += 1;
    }

    let cols = trees.len() / rows;

    let mut visible_trees: usize = 0;
    for row in 1..rows - 1 {
        let mut left_max = trees[row * cols];
        let mut right_max = trees[row * cols + cols - 1];
        for col in 1..cols - 1 {
            let i = row * cols + col;
            let tree_size = trees[i];
            if tree_size.abs() > left_max {
                left_max = tree_size.abs();
                if tree_size >= 0 {
                    trees[i] = -tree_size;
                    visible_trees += 1;
                }
            }

            let i = row * cols + (cols - col - 1);
            let tree_size = trees[i];
            if tree_size.abs() > right_max {
                right_max = tree_size.abs();
                if tree_size >= 0 {
                    trees[i] = -tree_size;
                    visible_trees += 1;
                }
            }
        }
    }

    for col in 1..cols - 1 {
        let mut top_max = trees[col];
        let mut bottom_max = trees[rows * cols - (cols - col)];
        for row in 1..rows - 1 {
            let i = col + rows * row;
            let tree_size = trees[i];
            if tree_size.abs() > top_max {
                top_max = tree_size.abs();
                if tree_size >= 0 {
                    trees[i] = -tree_size;
                    visible_trees += 1;
                }
            }

            let i = ((cols - row - 1) * rows) + col;
            let tree_size = trees[i];
            if tree_size.abs() > bottom_max {
                bottom_max = tree_size.abs();
                if tree_size >= 0 {
                    trees[i] = -tree_size;
                    visible_trees += 1;
                }
            }
        }
    }

    visible_trees += 2 * rows + 2 * cols - 4;
    Ok(visible_trees)
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(1854, part1().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }
}
