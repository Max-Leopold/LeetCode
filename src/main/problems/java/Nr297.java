package main.problems.java;

import main.util.java.TreeNode;

public class Nr297 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.deserialize("1;2;null;null;3;4;null;null;5;null;null;");
    }

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serialize(root, new StringBuilder()).toString();
        }

        private StringBuilder serialize(TreeNode root, StringBuilder stringBuilder) {
            if (root == null) {
                stringBuilder.append("null;");
            } else {
                stringBuilder.append(root.val);
                stringBuilder.append(";");
                serialize(root.left, stringBuilder);
                serialize(root.right, stringBuilder);
            }
            return stringBuilder;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }
            String[] stringNodes = data.split(";");
            TreeNode root = new TreeNode();
            deserialize(root, stringNodes, 0);
            return root.left;
        }

        public int deserialize(TreeNode root, String[] data, int index) {
            if (index >= data.length) {
                return -1;
            }
            if (data[index].equals("null")) {
                index++;
            } else {
                root.left = new TreeNode(Integer.parseInt(data[index]));
                index = deserialize(root.left, data, index + 1);
            }

            if (index >= data.length) {
                return -1;
            }
            if (data[index].equals("null")) {
                index++;
            } else {
                root.right = new TreeNode(Integer.parseInt(data[index]));
                index = deserialize(root.right, data, index + 1);
            }
            return index;
        }
    }
}
