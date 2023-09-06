package ak.po;

import ak.po.interfeces.ListInterface;
import ak.po.iterators.DoublyLinkedListIterator;
import ak.po.iterators.KillerIterator;
import ak.po.iterators.LinkedListIterator;
import ak.po.lists.CircularLinkedList;
import ak.po.lists.DoublyLinkedList;
import ak.po.lists.LinkedList;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        testList(new LinkedList());
        //testList(new DoublyLinkedList());
        //testList(new CircularLinkedList());
//        CircularLinkedList list = new CircularLinkedList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        testJosephus(list, 3, 2);
    }

    public static void testList(ListInterface list) {
        int N = 10000;
        Random random = new Random();
        double number;
        Integer value = null;
        int index;

        if (false) {
            for (int i = 0; i < N; i++) {
                number = random.nextDouble();
                if (number < 0.4) {
                    value = random.nextInt(100);
                    if (number < 0.2) {
                        list.add(value);
                        System.out.println("Dodano na końcu: " + value);
                    } else {
                        index = random.nextInt(list.size() + 2) - 1;
                        try {
                            list.add(value, index);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e);
                        }
                        System.out.println("Dodano po pozycji: " + index + " wartość: " + value);
                    }
                } else if (number < 0.8) {
                    try {
                        index = random.nextInt(list.size() + 2) - 1;
                        System.out.println("Element usunięty z pozycji " + index + " to " + list.remove(index));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e);
                    }
                } else {
                    try {
                        index = random.nextInt(list.size() + 2) - 1;
                        System.out.println("Element na pozycji " + index + " to " + list.get(index));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e);
                    }
                }
                if (number < 0.1) {
                    System.out.println("Wyczyszczono listę");
                    list.clear();
                }
                System.out.println(list);
            }
        }
        if(true){
        //test dodawania na końcu
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
        System.out.println();

        System.out.println("test dodawania na początku dla indeksu 0");
        list.add(-1, 0);
        System.out.println(list.toString());
        System.out.println();

        System.out.println("test dodawania na początku dla indeksu 0 dla pustej listy");
        list.clear();
        list.add(500, 0);
        System.out.println(list.toString());
        System.out.println();

        System.out.println("test dodawania z indeksami na początku");
        list.add(400, 0);
        System.out.println(list.toString());
        System.out.println();

        System.out.println("test dodawania z indeksami na końcu");
        list.add(600, 2);
        list.add(800, 3);
        list.add(900, 4);
        System.out.println(list.toString());
        System.out.println();

        System.out.println("test dodawania z indeksami w srodku");
        list.add(700, 3);
        System.out.println(list.toString());
        System.out.println();

        System.out.println("test get");
        System.out.println("get pierwszy element: " + list.get(1));
        System.out.println("get środkowy element: " + list.get(3));
        System.out.println("get ostatni element: " + list.get(list.size()));
        System.out.println();

        System.out.println("test set");
        list.set(401, 1);
        list.set(601, 3);
        list.set(901, list.size());
        System.out.println("get pierwszy element: " + list.get(1));
        System.out.println("get środkowy element: " + list.get(3));
        System.out.println("get ostatni element: " + list.get(list.size()));
        System.out.println();

        System.out.println("test contain 401");
        System.out.println(list.toString());
        System.out.println(list.contain(401));

        System.out.println("test remove");
        System.out.println(list.toString());
        System.out.println("usuń pierwszy");
        list.remove(1);
        System.out.println(list.toString());
        System.out.println("usuń środkowy");
        list.remove(3);
        System.out.println(list.toString());
        System.out.println("usuń ostatni");
        list.remove(list.size());
        System.out.println(list.toString());

        //System.out.println("test remove po value"); System.out.println(list.toString());
        //System.out.print("usuń"); System.out.println(" "+ ((CircularLinkedList)list).remove((Object)401)); System.out.println(list.toString());

        System.out.println();
        System.out.println("nowa lista testowa");
        DoublyLinkedList n = new DoublyLinkedList();
        for (int i = 0; i < 5; i++) {
            n.add(i);
        }
        System.out.println(n.toString());
        System.out.println("contain, czy zawiera element:");
        System.out.println("którego nie ma: " + n.contain(-1));
        System.out.println("pierwszy: " + n.contain(0));
        System.out.println("środkowy: " + n.contain(2));
        System.out.println("ostatni: " + n.contain(4));
        System.out.println();

        DoublyLinkedListIterator it = new DoublyLinkedListIterator(n);
        System.out.println(n.toString());
        it.first();
        System.out.println("current: " + it.current());
        it.previous();
        try {
            System.out.println("current: " + it.current());
        } catch (NullPointerException e) {
            System.out.println("nullpointer - osiagnięto previous od first");
        }
        it.first();
        it.next();
        it.next();
        it.next();
        System.out.println("current: " + it.current());
        it.previous();
        System.out.println("previous: " + it.current());
        it.last();
        System.out.println("last: " + it.current());
        it.previous();
        System.out.println("previous od last: " + it.current());
        }
    }

    public static void testJosephus(CircularLinkedList list, int step, int survived) {
        KillerIterator it = new KillerIterator(list, step, survived);
        System.out.println("Przed: " + list);
        for (it.first(); !it.isDone(); it.next()) {
            System.out.println("Ginie: " + list.remove(it.current()));
        }
        System.out.println("Przeżyli: " + list);
    }
}
