class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListEvenDelete {

    public static Node insert(Node head, int value) {

        Node newNode = new Node(value);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    public static Node deleteEvenNodes(Node head) {

        if (head == null) {
            return null;
        }

        while (head != null && head.data % 2 == 0) {
            head = head.next;
        }

        Node current = head;

        while (current != null && current.next != null) {

            if (current.next.data % 2 == 0) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] values = {2, 3, 4, 5, 6, 7, 8, 9};  

        Node head = null;

        for (int i = 0; i < values.length; i++) {
            head = insert(head, values[i]);
        }

        System.out.println("Original List:");
        printList(head);

        head = deleteEvenNodes(head);

        System.out.println("After Deleting Even Nodes:");
        printList(head);
    }
}