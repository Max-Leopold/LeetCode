package main.problems.java;

import java.util.ArrayList;
import java.util.List;

public class Nr590 {

    public List<Integer> postorder(Node root) {
        return postorder(root, new ArrayList<>());
    }

    public List<Integer> postorder(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        if (root.children != null) {
            for (Node children : root.children) {
                postorder(children, list);
            }
        }
        list.add(root.val);
        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
