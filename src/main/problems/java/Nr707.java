package main.problems.java;

public class Nr707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);              // return 3
    }

    static class MyLinkedList {

        private int size;
        private Node head;

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            Node indexNode = getNode(index);
            if (indexNode == null) {
                return -1;
            }
            return indexNode.val;
        }

        private Node getNode(int index) {
            if (index > size - 1) {
                return null;
            } else {
                Node currentNode = head;
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.next;
                }
                return currentNode;
            }
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Node newNode = new Node(val);
            Node tail = getNode(size - 1);
            if (tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                Node newNode = new Node(val);
                Node beforeNode = getNode(index - 1);
                if (beforeNode != null) {
                    newNode.next = beforeNode.next;
                    beforeNode.next = newNode;
                    size++;
                }
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index == 0) {
                head = head.next;
            } else {
                if (index <= size - 1) {
                    Node beforeNode = getNode(index - 1);
                    beforeNode.next = beforeNode.next.next;
                    size--;
                }
            }
        }

        private class Node {
            private Node next;
            private int val;

            public Node(int val) {
                this.val = val;
            }
        }
    }
}
