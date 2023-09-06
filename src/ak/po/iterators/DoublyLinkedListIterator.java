package ak.po.iterators;

import ak.po.interfeces.IteratorInterface;
import ak.po.lists.DoublyLinkedList;
import ak.po.lists.LinkedList;

public class DoublyLinkedListIterator implements IteratorInterface
{
    private DoublyLinkedList list;
    private DoublyLinkedList.Node current;

    public DoublyLinkedListIterator(DoublyLinkedList l)
    {
        list = l;
        current = null;
    }

    @Override
    public void previous()
    {
        if(current.equals(list.getFirst())) {
            current = null;
        } else {
            current = current.prev;
        }
            /**
         * Uzupełnić fragment kodu.
         * Należy przejść po liście od początku do elmentu poprzedzającego.
         */
    }

    @Override
    public void next()
    {
        current = current.next;
    }

    @Override
    public void first()
    {
        current = list.getFirst();
    }

    @Override
    public void last()
    {
        current = list.getLast();
    }

    @Override
    public boolean isDone() {
        return current == null;
    }

    @Override
    public Object current() {
        return current.value;
    }
}
