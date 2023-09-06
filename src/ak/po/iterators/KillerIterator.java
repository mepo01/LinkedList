package ak.po.iterators;

import ak.po.interfeces.IteratorInterface;
import ak.po.lists.CircularLinkedList;

public class KillerIterator implements IteratorInterface
{
    private CircularLinkedList list;
    private int step, survived;
    private CircularLinkedList.Node current;

    public KillerIterator(CircularLinkedList l, int st, int surv)
    {
        list = l;
        step = st;
        survived = surv;
    }

    @Override
    public void previous()
    {
        int licznik = 0;
        while(!isDone()) {
            next();
            licznik++;
        }
        first();
        for(int i = 0; i < list.size()-licznik-1 ; i++) {
            next();
        }
    }

    @Override
    public void next()
    {
        for (int i = 0; i < step; i++) {
            current = current.next;
        }

        /**
         * Uzupełnić brakujący kod
         */
    }

    @Override
    public void first()
    {
        current = list.getFirst();
        for (int i = 0; i < step-2; i++) {
            current = current.next;
        }

    }

    @Override
    public void last()
    {
        current = list.getLast();
    }

    @Override
    public boolean isDone()
    {
        return list.size() == survived;
    }

    @Override
    public Object current()
    {
        return current.value;
    }
}
