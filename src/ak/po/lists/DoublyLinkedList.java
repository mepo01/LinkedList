package ak.po.lists;

import ak.po.interfeces.IteratorInterface;
import ak.po.interfeces.ListInterface;
import ak.po.iterators.DoublyLinkedListIterator;

public class DoublyLinkedList implements ListInterface
{
    public class Node
    {
        public Object value;
        public Node next, prev;
        public Node(Object v)
        {
            value = v;
            next = prev = null;
        }
    }

    private int size;
    private Node first;
    private Node last;

    public DoublyLinkedList()
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
         //* Uzupełnić fragment kodu wg. algorytmu:
         //* - Jeśli lista jest pusta, dodajemy do listy ustawiając odpowiednio początek i koniec.
         Node newNode = new Node(value);
         if(isEmpty()) {
             first = newNode;
             newNode.prev = null;
             last = first;
             size++;
             return;
         } else {
             //* - Jeśli lista nie jest pusta, dodajemy nowy element na końcu.
             last.next = newNode;
             newNode.prev = last;
             last = last.next;
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
         //* Uzupełnić fragment kodu wg. algorytmu:
         //* - Jeśli index == 0, dodajemy nowy element na początku listy, rozważając, czy lista jest pusta.
         if(index == 0 && isEmpty()) {
             first = newNode;
             last = newNode;
             size++;
             return;
         } else if(index == 0) {
             newNode.next = first;
             first.prev = newNode;
             first = newNode;
             size++;
         }
         //Dodajemy nowy element do listy. Należy sprawdzić, czy dodawany element nie jest ostatnim, wtedy modyfikujemy ostatni.
         else if (index == size) {
             last.next = newNode;
             newNode.prev = last;
             last = newNode;
             size++;
         }
         //* - Jeśli index > 0, przesuwamy się na liście do elementu, po którym będziemy dodawać.
         else {
             Node tempNode = first;
             int licznik = 1;
             while (licznik < index) {
                 tempNode = tempNode.next;
                 licznik++;
             }
             newNode.next = tempNode.next;
             tempNode.next = newNode;
             newNode.prev = tempNode;
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
         * Uzuepłnić fragment kodu przesuwając się do wskazanego miejsca.
         */

        return node.value;
    }

    @Override
    public Object remove(int index)
    {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Niewłaściwy indeks: " + index + " dla listy o rozmiarze: " + size);
        }

        Node toRemoved = null;
        if (index == 1) {
            /**
             * Przypadek 1: usuwamy pierwszy element listy
             */
            toRemoved = first;
            first = first.next;
            if (first != null) {
                first.prev = null;
            } else {
                last = null;
            }
        } else {
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

            /**
             * Przypadek 2: usuwamy element ze środka lub końca listy
             */
            /**
             * Uzupełnić brakujący kod
             */
            size--;
        return toRemoved.value;
    }

    @Override
    public boolean contain(Object value)
    {
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
        return new DoublyLinkedListIterator(this);
    }

    @Override
    public String toString()
    {
        String buffer = "";
        IteratorInterface it = getIterator();
        for (it.first(); !it.isDone(); it.next()) {
            buffer += it.current() + " <=> ";
        }
        buffer += "null";
        return buffer;
    }
}
