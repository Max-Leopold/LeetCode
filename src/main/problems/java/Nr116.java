package main.problems.java;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Nr116 {
    public Node connect(Node root) {
        Node[] lastNodePerLevel = new Node[12];
        connect(lastNodePerLevel, root, 0);
        return root;
    }

    private void connect(Node[] lastNodePerLevel, Node root, int currentLevel) {
        if (root == null) {
            return;
        }
        if (lastNodePerLevel[currentLevel] != null) {
            lastNodePerLevel[currentLevel].next = root;
        }
        lastNodePerLevel[currentLevel] = root;
        connect(lastNodePerLevel, root.left, currentLevel + 1);
        connect(lastNodePerLevel, root.right, currentLevel + 1);
    }
}
