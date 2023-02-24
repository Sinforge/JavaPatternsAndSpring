package Practice3;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet implements Set {
    private HashSet data = new HashSet();
    public MySet() {
        data = new HashSet();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {

        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public synchronized Iterator iterator()
    {
        return data.iterator();
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public synchronized boolean add(Object o) {
        return data.add(o);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return data.remove(o);
    }

    @Override
    public synchronized boolean addAll(Collection c) {

        return data.addAll(c);
    }

    @Override
    public synchronized void clear() {
        data.clear();
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        return data.remove(c);
    }

    @Override
    public synchronized boolean retainAll(Collection c) {

        return data.retainAll(c);
    }

    @Override
    public boolean containsAll(Collection c)
    {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}