use super::file_tree::generate_file_tree;

extern crate test;

const FILESYSTEM_SIZE: usize = 70000000;
const NECESSARY_SPACE: usize = 30000000;

pub fn part2() -> Result<usize, Box<dyn std::error::Error>> {
    let file_tree = generate_file_tree()?;
    let currently_used = file_tree.nodes[0].total_size;
    let space_to_free = NECESSARY_SPACE - (FILESYSTEM_SIZE - currently_used);
    let result = file_tree
        .nodes
        .iter()
        .map(|n| n.total_size)
        .filter(|s| s > &space_to_free)
        .min()
        .unwrap();

    Ok(result)
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part2() {
        assert_eq!(1544176, part2().unwrap());
    }

    #[bench]
    fn bench_part2(b: &mut Bencher) {
        b.iter(|| {
            part2().unwrap();
        })
    }
}
