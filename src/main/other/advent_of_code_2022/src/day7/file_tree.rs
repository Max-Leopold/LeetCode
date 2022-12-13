use std::collections::HashMap;
use std::fs::File;
use std::io::{BufRead, BufReader};

use itertools::Itertools;

#[derive(Default)]
pub struct Graph {
    pub nodes: Vec<Node>,
}

#[derive(Default)]
pub struct Node {
    pub total_size: usize,
    children: HashMap<String, usize>,
    parent: Option<usize>,
}

pub fn generate_file_tree() -> Result<Graph, Box<dyn std::error::Error>> {
    let file = File::open("input/day7/input.txt")?;
    let reader = BufReader::new(file);

    let mut graph = Graph::default();

    let root_id = 0;
    let mut current_node_id = 0;

    let root = Node::default();
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
                            parent: Some(current_node_id),
                            ..Default::default()
                        });

                        graph.nodes[current_node_id]
                            .children
                            .entry(name.to_string())
                            .or_insert(id);
                    } else {
                        let (size, _) = split_iter.next_tuple().unwrap();

                        graph.nodes[current_node_id].total_size += size.parse::<usize>().unwrap();
                    }
                }
                _ => {
                    panic!("Received unexpected output!")
                }
            }
        }
    }

    calculate_directory_sizes(&mut graph, root_id);
    return Ok(graph);
}

fn calculate_directory_sizes(graph: &mut Graph, root: usize) -> usize {
    let mut subdirecotry_size = 0;
    for (_, child_id) in &graph.nodes[root].children.clone() {
        subdirecotry_size += calculate_directory_sizes(graph, *child_id);
    }
    graph.nodes[root].total_size += subdirecotry_size;

    return graph.nodes[root].total_size;
}
