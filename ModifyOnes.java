class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class ModifyOnes {

    public static Node modifyList(Node head) {

        Node current = head;

        while (current != null) {

            if (current.data == '1') {

                int count = 0;
                Node temp = current;

                while (temp != null && temp.data == '1') {
                    count++;
                    temp = temp.next;
                }

                current.data = (char)(count + '0');
                current.next = temp;
            }

            current = current.next;
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

        Node head = new Node('A');
        head.next = new Node('1');
        head.next.next = new Node('1');
        head.next.next.next = new Node('1');
        head.next.next.next.next = new Node('B');
        head.next.next.next.next.next = new Node('1');
        head.next.next.next.next.next.next = new Node('1');
        head.next.next.next.next.next.next.next = new Node('C');

        System.out.println("Original List:");
        printList(head);

        head = modifyList(head);

        System.out.println("Modified List:");
        printList(head);
    }
}