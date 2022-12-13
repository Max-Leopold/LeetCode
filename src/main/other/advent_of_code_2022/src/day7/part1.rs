use super::file_tree::generate_file_tree;

extern crate test;

pub fn part1() -> Result<usize, Box<dyn std::error::Error>> {
    let file_tree = generate_file_tree()?;
    let result = file_tree
        .nodes
        .iter()
        .map(|n| n.total_size)
        .filter(|s| s <= &100000)
        .sum();

    Ok(result)
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        assert_eq!(1581595, part1().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }
}
