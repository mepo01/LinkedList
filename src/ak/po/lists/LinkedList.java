package ak.po.lists;

import ak.po.interfeces.IteratorInterface;
import ak.po.interfeces.ListInterface;
import ak.po.iterators.LinkedListIterator;

public class LinkedList implements ListInterface
{
    /**
     * Klasa wewnętrzna opisująca pojedynczy węzeł listy jednokierunkowej.
     */
    public class Node
    {
        public Object value;
        public Node next;
        public Node(Object v)
        {
            value = v;
            next = null;
        }
    }

    private int size;
    private Node first;
    private Node last;

    public LinkedList()
    {
        clear();
    }

    public Node getFirst()
    {
        return first;
    }

    public Node getLast()
    {
        return last;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void clear()
    {
        first = last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void add(Object value)
    {
        Node newNode = new Node(value);
        //* - Jeśli lista jest pusta, dodajemy do listy ustawiając odpowiednio początek i koniec.
        if(size == 0) {
            first = newNode;
            last = first;
            size++;
        }
        //* - Jeśli lista nie jest pusta, dodajemy nowy element na końcu.
        else {
            last.next = newNode;
            last = newNode;
            size++;
        }
    }

    @Override
    public void add(Object value, int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Niewłaściwy indeks: " + index + " dla listy o rozmiarze: " + size);
        }
        Node newNode = new Node(value);
        // * Uzupełnić fragment kodu wg. algorytmu:
        // * - Jeśli index == 0, dodajemy nowy element na początku listy, rozważając, czy lista jest pusta.
        if(index == 0 && size == 0) {
            first = newNode;
            last = newNode;
            size++;
            return;
        } else if(index == 0) {
            newNode.next = first;
            first = newNode;
            size++;
        }
        // *   Dodajemy nowy element do listy. Należy sprawdzić, czy dodawany element nie jest ostatnim, wtedy modyfikujemy ostatni.
        else if(index == size) {
            last.next = newNode;
            last = newNode;
            size++;
        }
        // * - Jeśli index > 0, przesuwamy się na liście do elementu, po którym będziemy dodawać.
        else {
            Node tempNode = first;
            int licznik = 1;
            while (licznik < index) {
                tempNode = tempNode.next;
                licznik++;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            size++;
        }
    }

    @Override
    public void set(Object value, int index) throws IndexOutOfBoundsException
    {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Niewłaściwy indeks: " + index + " dla listy o rozmiarze: " + size);
        }
        Node node = first;
        int licznik = 1;
        while (licznik<index) {
            licznik++;
            node = node.next;
        }
        node.value = value;
        /**
         * Uzupełnić fragment kodu przesuwając się do wskazanego miejsca.
         */

    }

    @Override
    public Object get(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Niewłaściwy indeks: " + index + " dla listy o rozmiarze: " + size);
        }
        Node node = first;
        int licznik = 1;
        while (licznik<index) {
            licznik++;
            node = node.next;
        }
        /**
         * Uzupełnić fragment kodu przesuwając się do wskazanego miejsca.
         */

        return node.value;
    }

    @Override
    public Object remove(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Niewłaściwy indeks: " + index + " dla listy o rozmiarze: " + size);
        }
        Node toRemoved;
        if (index == 1) {
            /**
             * Przypadek 1: usuwamy pierwszy element listy
             */
            toRemoved = first;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            /**
             * Przypadek 2: usuwamy element ze środka lub końca listy
             */
            Node node = first;
            int i = 1;
            while (i+1 < index) {
                node = node.next;
                i++;
            }
            // zapamiętujemy usuwany
            toRemoved = node.next;
            // eliminujemy usuwany z listy
            node.next = node.next.next;
            // jeśli usuwany był ostatnim, to aktualizujemy ostatni
            if (node.next == null) {
                last = node;
            }
        }
        size--;
        return toRemoved.value;
    }

    @Override
    public boolean contain(Object value) {
        Node node = first;
        for (int i = 0; i < size(); i++) {
            if((int)node.value == (int)value) return true;
            node = node.next;
        }



        /**
         * Uzuepłnić brakujący fragment kodu.
         */

        return false;
    }

    public IteratorInterface getIterator()
    {
        return new LinkedListIterator(this);
    }

    @Override
    public String toString()
    {
        String buffer = "";
//        Node node = first;
//
//        while (node != null) {
//            buffer += node.value.toString() + " -> ";
//            node = node.next;
//        }
        IteratorInterface it = getIterator();
        for (it.first(); !it.isDone(); it.next()) {
            buffer += it.current() + " -> ";
        }
        buffer += "null";
        return buffer;
    }
}
