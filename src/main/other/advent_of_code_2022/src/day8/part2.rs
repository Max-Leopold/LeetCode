use std::fs::File;
use std::io::{BufRead, BufReader};

pub fn part2() -> Result<usize, Box<dyn std::error::Error>> {
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

    let mut result = 0;
    for idx in 0..trees.len() {
        let mut idx_result = 1;
        let mut moved_idx = idx;
        let mut view_distance = 0;
        // Look up
        while let Some(moved_up_idx) = up(moved_idx, rows, cols) {
            moved_idx = moved_up_idx;
            view_distance += 1;
            if trees[moved_idx] >= trees[idx] {
                break;
            }
        }
        idx_result *= view_distance;
        if idx_result == 0 {
            continue;
        }
        moved_idx = idx;
        view_distance = 0;

        // Look down
        while let Some(moved_up_idx) = down(moved_idx, rows, cols) {
            moved_idx = moved_up_idx;
            view_distance += 1;
            if trees[moved_idx] >= trees[idx] {
                break;
            }
        }
        idx_result *= view_distance;
        if idx_result == 0 {
            continue;
        }
        moved_idx = idx;
        view_distance = 0;

        // Look right
        while let Some(moved_up_idx) = right(moved_idx, rows, cols) {
            moved_idx = moved_up_idx;
            view_distance += 1;
            if trees[moved_idx] >= trees[idx] {
                break;
            }
        }
        idx_result *= view_distance;
        if idx_result == 0 {
            continue;
        }
        moved_idx = idx;
        view_distance = 0;

        // Look left
        while let Some(moved_up_idx) = left(moved_idx, rows, cols) {
            moved_idx = moved_up_idx;
            view_distance += 1;
            if trees[moved_idx] >= trees[idx] {
                break;
            }
        }
        idx_result *= view_distance;
        if idx_result == 0 {
            continue;
        }

        result = result.max(idx_result);
    }

    Ok(result)
}

fn up(idx: usize, rows: usize, cols: usize) -> Option<usize> {
    if idx as isize - cols as isize >= 0 {
        return Some(idx - cols);
    }
    None
}

fn down(idx: usize, rows: usize, cols: usize) -> Option<usize> {
    if idx + cols < rows * cols {
        return Some(idx + cols);
    }
    None
}

fn right(idx: usize, rows: usize, cols: usize) -> Option<usize> {
    if (idx + 1) / rows == idx / rows {
        return Some(idx + 1);
    }
    None
}

fn left(idx: usize, rows: usize, cols: usize) -> Option<usize> {
    if idx as isize - 1 > 0 && (idx - 1) / rows == idx / rows {
        return Some(idx - 1);
    }
    None
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part2() {
        assert_eq!(527340, part2().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }
}
