extern crate test;

use std::cmp::min;
use std::collections::HashMap;
use std::fs::File;
use std::io::{BufRead, BufReader};

use itertools::Itertools;

#[derive(Default)]
struct Graph {
    nodes: Vec<Node>,
}

#[derive(Default)]
struct Node {
    size: usize,
    name: String,
    dir: bool,
    children: HashMap<String, usize>,
    parent: Option<usize>,
}

pub fn part1() -> Result<usize, Box<dyn std::error::Error>> {
    let file = File::open("input/day7/input.txt")?;
    let reader = BufReader::new(file);

    let mut graph = Graph::default();

    let root_id = 0;
    let mut current_node_id = 0;

    let root = Node {
        dir: true,
        ..Default::default()
    };
    graph.nodes.push(root);

    let mut last_command = "";

    let lines = reader.lines().peekable();
    for line in lines {
        let line = line.unwrap();
        let mut split_iter = line.split_whitespace().peekable();
        if split_iter.peek().unwrap() == &"$" {
            // Found command
            let mut split_iter = split_iter.skip(1);
            match split_iter.next().unwrap() {
                "ls" => {
                    last_command = "ls";
                }
                "cd" => {
                    match split_iter.next().unwrap() {
                        ".." => {
                            current_node_id = graph.nodes[current_node_id].parent.unwrap_or(0);
                        }
                        "/" => {
                            current_node_id = root_id;
                        }
                        dir_name => {
                            current_node_id = graph.nodes[current_node_id].children[dir_name]
                        }
                    }
                    last_command = "cd";
                }
                _ => {
                    panic!("Unexpected command")
                }
            }
        } else {
            // Command output
            match last_command {
                "ls" => {
                    if split_iter.peek().unwrap() == &"dir" {
                        let (_, name) = split_iter.next_tuple().unwrap();
                        let id = graph.nodes.len();
                        graph.nodes.push(Node {
                            size: 0,
                            name: name.to_string(),
                            dir: true,
                            children: HashMap::new(),
                            parent: Some(current_node_id),
                        });

                        graph.nodes[current_node_id]
                            .children
                            .entry(name.to_string())
                            .or_insert(id);
                    } else {
                        let (size, name) = split_iter.next_tuple().unwrap();
                        let id = graph.nodes.len();
                        graph.nodes.push(Node {
                            size: size.parse().unwrap(),
                            name: name.to_string(),
                            dir: false,
                            children: HashMap::new(),
                            parent: Some(current_node_id),
                        });

                        graph.nodes[current_node_id]
                            .children
                            .entry(name.to_string())
                            .or_insert(id);
                    }
                }
                _ => {
                    panic!("Received unexpected output!")
                }
            }
        }
    }

    let (_, result) = get_directory_size_sum(&graph, root_id, 100000);
    let total_space = calculate_directory_sizes(&mut graph, root_id);
    println!("Total space: {}", total_space);
    let unused_space = 70000000 - total_space;
    let required_space = 30000000 - unused_space;
    println!("Required_space: {}", required_space);
    println!(
        "Min over: {}",
        find_min_over(&mut graph, root_id, required_space)
    );
    // let (_, directory_to_delete) = directory_to_delete(&mut graph, root_id, required_space);
    // println!("Directory to delete size: {}", directory_to_delete);

    Ok(result)
}

fn get_directory_size_sum(graph: &Graph, root: usize, max_size: usize) -> (usize, usize) {
    let node = &graph.nodes[root];

    let mut return_sum = 0;
    let mut total_sum = graph.nodes[root].size;
    for (_, child) in &graph.nodes[root].children {
        let (add_total_sum, add_return_sum) = get_directory_size_sum(graph, *child, max_size);
        total_sum += add_total_sum;
        return_sum += add_return_sum;
    }
    if node.dir && total_sum < max_size {
        return_sum += total_sum;
    }

    (total_sum, return_sum)
}

fn calculate_directory_sizes(graph: &mut Graph, root: usize) -> usize {
    let mut size = graph.nodes[root].size;
    for (_, child_id) in &graph.nodes[root].children.clone() {
        size += calculate_directory_sizes(graph, *child_id);
    }
    graph.nodes[root].size = size;

    return size;
}

fn find_min_over(graph: &mut Graph, root: usize, min_size: usize) -> usize {
    let node = &graph.nodes[root];
    let mut min_over = usize::MAX;
    if !node.dir {
        return min_over;
    }

    println!("{},", node.size);

    if node.size > min_size {
        min_over = min(min_over, node.size);
    }
    for (_, child_id) in node.children.clone() {
        let sub_directory_min_over = find_min_over(graph, child_id, min_size);
        if sub_directory_min_over > min_size {
            min_over = min(min_over, sub_directory_min_over);
        }
    }

    return min_over;
}

#[cfg(test)]
mod tests {
    use super::*;
    use test::Bencher;

    #[test]
    fn test_part1() {
        // assert_eq!("WSFTMRHPP", part1().unwrap());
    }

    #[bench]
    fn bench_part1(b: &mut Bencher) {
        b.iter(|| {
            part1().unwrap();
        })
    }
}
