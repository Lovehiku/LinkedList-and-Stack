public class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("position out of range");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node temp = head;
        if (position == 1) {
            head = temp.next;
            return;
        }
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("position out of range");
            return;
        }
        temp.next = temp.next.next;
    }

    public void deleteAfterNode(int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Node not found or no node to delete after it");
            return;
        }
        current.next = current.next.next;
    }

    public boolean searchNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        list.display();
        list.deleteAtPosition(2);
        list.display();
        list.insertAtPos(40, 2);
        list.display();
        list.deleteAfterNode(10);
        list.display();
        System.out.println(list.searchNode(30));
        System.out.println(list.searchNode(50));
    }
}

public class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("stack underflow");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek() {
        if (top == null) {
            System.out.println("stack is empty");
            return -1;
        }
        return top.data;
    }

    public void display() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Top element is " + stack.peek());
        System.out.println("Popped element is " + stack.pop());
        stack.display();
        System.out.println("Top element is " + stack.peek());
    }
}
