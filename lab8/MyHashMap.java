import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedList;

public class MyHashMap<K, V> implements Map61B<K , V>{

    int noOfBuckets;
    double loadFactor;
    LinkedList<Entry>[] buckets;
    HashSet keys;

    public MyHashMap(){

        noOfBuckets = 16;
        this.loadFactor = 0.75;
        buckets = new LinkedList[noOfBuckets];
        for (int i = 0; i<noOfBuckets; i++){
            buckets[i] = new LinkedList<>();
        }

        keys = new HashSet();

    }

    /** used to put key and value together */
    private class Entry{

        K key;
        V value;

        private Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        private void replaceBy(V value){

            this.value = value;

        }

    }

    @Override
    public void clear(){
        buckets = new LinkedList[noOfBuckets];
        for (int i = 0; i<noOfBuckets; i++){
            buckets[i] = new LinkedList<>();
        }
        keys.clear();
    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key){
        return keys.contains(key);
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key){

        int keyHashCode = 0x7fffffff & key.hashCode();
        int modularHashCode = keyHashCode%noOfBuckets;

        for (Entry e : buckets[modularHashCode]){
            if (e.key.equals(key)){
                return e.value;
            }
        }
        return null;
    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size(){
        return keys.size();
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    @Override
    public void put(K key, V value){
        /** TODO: implement*/

        keys.add(key);
        grow();
        int keyHashCode = 0x7fffffff & key.hashCode();
        int modularHashCode = keyHashCode%noOfBuckets;

        for (Entry e : buckets[modularHashCode]){
            if (e.key == key){
                e.replaceBy(value);
                return;
            }
        }

        buckets[modularHashCode].add(new Entry(key, value));
    }

    /** checks to see if buckets are too filled */
    private void grow(){

        if (size()/noOfBuckets > loadFactor){

            noOfBuckets = noOfBuckets *2;
            buckets = new LinkedList[noOfBuckets];
            for (int i = 0; i<noOfBuckets; i++){
                buckets[i]= new LinkedList<>();
            }

            for (K key : keySet()){
                V value = this.get(key);

                put(key, value);

            }
        }

    }

    /** Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet(){
        return keys;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    @Override
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }

    /** allows myhashmap to be iterable */
    @Override
    public Iterator iterator(){
        return keys.iterator();
    }

}
