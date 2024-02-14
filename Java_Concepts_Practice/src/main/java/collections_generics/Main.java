package collections_generics;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Pair<Double, Integer>(40.22, 20));
        System.out.println(new Pair<String, Integer>("Sahil", 20));
        System.out.println(new Pair<Long, Integer>(20L, 20));

        System.out.println(new Pair<CustomType, Integer>(new CustomType<Integer>(32), 20));
        System.out.println(new Pair<CustomType, Integer>(new CustomType<String>("Custom type"), 20));

        //LinkedList - Faster at inserting & deleting dynamically sized data, But more memory to store & more time for searching
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Sahil_1");
        linkedList.add("Sahil_2");
        linkedList.addFirst("Added at first");
        linkedList.addLast("Added at last");
        linkedList.add(2, "Adding at indiex 2");
        System.out.println("Get 1st item" + linkedList.getFirst());
        System.out.println("Get last item" + linkedList.getLast());
        System.out.println("Get item at index 2" + linkedList.get(2));
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove(2);
        linkedList.contains("Sahil_1");
        linkedList.clear();

        //Stack - for reversing or keep track of states (Runtime Stack)
        Stack<String> deckOfCards = new Stack<>();
        deckOfCards.push("1");
        deckOfCards.push("2");
        System.out.println("Card at Top: " + deckOfCards.peek());
        String removedItem  = !deckOfCards.isEmpty() ? deckOfCards.pop() : "Stack is Empty";

        //Queue - storing the order of process, or Use PriorityQueue implementation instead of LinkedList
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        System.out.println("Next Item in Line: " + queue.peek());
        queue.remove();
        String removedQueueItem = !queue.isEmpty() ? queue.remove(): "Queue is Empty";

        //HashMap (more memory) - allow duplicate val unlike HashSet, allow null key, methods aren't synchronized so not thread safe but better performance than synchronized HashTable
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println("Get:  " + map.get(2));
        System.out.println(map.keySet());
        System.out.println(map.values());
        map.remove(2);


        //Delete the middle of singly-linked list
        Node<Integer> head = buildNode(3);
        Node<Integer> nodeA = buildNode(78);
        head.setNext(nodeA);
        Node<Integer> nodeB = buildNode(29);
        nodeA.setNext(nodeB);
        Node<Integer> nodeC = buildNode(99);
        nodeB.setNext(nodeC);
        printLinkedList(head);
        deleteMiddleNode(head);
        printLinkedList(head);


        //Convert int to binary string
        printBinary(10);

    }

    private static void printBinary(int n) {
        if (n<=0) {
            System.out.println("No Binary for -ve numbers");
            return;
        } else {
            System.out.println("Binary of " + n + " is:" + Integer.toBinaryString(n));
        }
    }

    private static Node deleteMiddleNode(Node head) {
        if (head == null || head.getNext()==null) return head;
        Node slow = head, fast = head;
        Node previous = null;

        while (fast!=null && fast.getNext()!=null){
            fast = fast.getNext().getNext();
            previous = slow;
            slow = slow.getNext();
        }
        //Delete middle node i.e slow node
        previous.setNext(slow.getNext());
        return head;
    }

    private static void printLinkedList(Node<Integer> head) {
        while (head!=null){
            System.out.println(head.getData() + " , ");
            head = head.getNext();
        }
        System.out.println("END");
    }

    public static Node<Integer> buildNode(int data){
        Node node = new Node();
        node.setData(data);
        node.setNext(null);
        return node;
    }

}
