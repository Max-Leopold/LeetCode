package main.problems.java;

import main.util.java.Node;

import java.util.IdentityHashMap;
import java.util.Map;

public class Nr138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> isomorphism = new IdentityHashMap<>();
        Node newHead = new Node(head.val);
        isomorphism.put(head, newHead);

        while (head.next != null) {

            Node clonedHead = isomorphism.get(head);
            if (isomorphism.containsKey(head.next)) {
                clonedHead.next = isomorphism.get(head.next);
            } else {
                clonedHead.next = new Node(head.next.val);
                isomorphism.put(head.next, clonedHead.next);
            }

            if (head.random != null) {
                if (isomorphism.containsKey(head.random)) {
                    clonedHead.random = isomorphism.get(head.random);
                } else {
                    clonedHead.random = new Node(head.random.val);
                    isomorphism.put(head.random, clonedHead.random);
                }
            }

            head = head.next;
        }

        // Add last random
        if (head.random != null) {
            if (isomorphism.containsKey(head.random)) {
                isomorphism.get(head).random = isomorphism.get(head.random);
            } else {
                isomorphism.get(head).random = new Node(head.random.val);
                isomorphism.put(head.random, isomorphism.get(head).random);
            }
        }

        return newHead;
    }
}
