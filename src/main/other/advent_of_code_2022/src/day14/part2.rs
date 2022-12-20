use itertools::Itertools;
use std::collections::HashSet;
use std::fs::File;
use std::io::{BufRead, BufReader};

type Point = [isize; 2];

fn add_points(a: Point, b: Point) -> Point {
    point_from_iterator(a.iter().zip(&b).map(|(a, b)| a + b))
}

fn point_from_iterator<F: Iterator<Item = isize>>(src: F) -> Point {
    let mut res = [0, 2];
    for (rref, val) in res.iter_mut().zip(src) {
        *rref = val;
    }
    res
}

pub fn part2() -> Result<usize, Box<dyn std::error::Error>> {
    let file = File::open("input/day14/input.txt")?;
    let reader = BufReader::new(file);

    let mut blocked = HashSet::new();
    let mut max_y = 0;
    for line in reader.lines() {
        let line = line.unwrap();
        for (mut p1, p2) in line
            .split(" -> ")
            .map(|p| point_from_iterator(p.split(",").map(|x| x.parse::<isize>().unwrap())))
            .tuple_windows()
        {
            max_y = max_y.max(p1[1].max(p2[1]));
            let movement = [(p2[0] - p1[0]).signum(), (p2[1] - p1[1]).signum()];
            while p1 != p2 {
                blocked.insert(p1.clone());
                p1 = add_points(p1, movement);
            }
            blocked.insert(p2);
        }
    }

    let mut count = 0;
    sim(&mut blocked, [500, 0], max_y + 2, &mut count);
    Ok(count)
}

fn sim(blocked: &mut HashSet<Point>, pos: Point, max_y: isize, count: &mut usize) -> bool {
    if pos[1] >= max_y {
        return true;
    }

    if blocked.contains(&pos) {
        return true;
    }

    let res = sim(blocked, add_points(pos, [0, 1]), max_y, count)
        && sim(blocked, add_points(pos, [-1, 1]), max_y, count)
        && sim(blocked, add_points(pos, [1, 1]), max_y, count);

    if res {
        *count += 1;
        blocked.insert(pos);
    }

    res
}
