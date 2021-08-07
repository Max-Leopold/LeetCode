package main.problems.java;

public class Nr117 {
    public Node connect(Node root) {
        Node[] lastNodePerLevel = new Node[6000];
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
