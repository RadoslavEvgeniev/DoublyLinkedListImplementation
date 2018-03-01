import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);


        list.forEach(System.out::println);
        System.out.println(Arrays.toString(list.toArray()));
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeLast();
        list.removeLast();
        list.removeLast();
//        System.out.println("################################");
//
//        list.addLast(5);
//        list.addFirst(3);
//        list.addFirst(2);
//        list.addLast(10);
//        System.out.printf("Count = %d\n", list.size());
//
//        list.forEach(System.out::println);
//        System.out.println("################################");
//
//        list.removeFirst();
//        list.removeLast();
//        list.removeFirst();
//
//        list.forEach(System.out::println);
//        System.out.println("################################");
//
//        list.removeLast();
//
//        list.forEach(System.out::println);
//        System.out.println("################################");

    }
}
