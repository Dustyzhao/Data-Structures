import java.util.Scanner;

/**
 * @author DUSTY
 */
public class Main {

    public static void main(String[] args) {

        //测试LRUBaseLinkedList

        LRUBaseLinkedList lruBaseLinkedList = new LRUBaseLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            lruBaseLinkedList.add(scanner.nextInt());
            lruBaseLinkedList.printAll();
        }


//        LinkedList<Integer> linkedList = new LinkedList<>();
//
//        for (int i = 0; i < 5; i++) {
//            linkedList.addFirst(i);
//            System.out.println(linkedList);
//        }
//
//        linkedList.add(2,666);
//        System.out.println(linkedList);
//
//        linkedList.remove(2);
//        System.out.println(linkedList);
//
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//        linkedList.removeLast();
//        System.out.println(linkedList);
    }

}
