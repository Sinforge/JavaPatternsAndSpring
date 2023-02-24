package Practice3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyMap implements Map {
    private final HashMap hashMap = new HashMap();
    private final Lock lock = new ReentrantLock();
    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public boolean isEmpty()
    {
        return hashMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {

        return hashMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return hashMap.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        Object getObj;
        lock.lock();
        getObj = hashMap.get(key);
        lock.unlock();
        return getObj;
    }

    @Override
    public Object put(Object key, Object value) {
        Object putObj;
        lock.lock();
        putObj = hashMap.put(key, value);
        lock.unlock();
        return putObj;

    }

    @Override
    public Object remove(Object key) {
        Object removeObj;
        lock.lock();
        removeObj = hashMap.remove(key);
        lock.unlock();
        return removeObj;
    }

    @Override
    public void putAll(Map m) {
        lock.lock();
        hashMap.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        hashMap.clear();
        lock.unlock();
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
