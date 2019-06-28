import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedList;

public class MyHashMap<K, V> implements Map61B<K , V>{

    int size;
    double loadFactor;
    // TODO
    // LinkedList buckets;
    HashSet keys;

    public MyHashMap(){

        size = 16;
        this.loadFactor = 0.75;
        // TODO
        // buckets =

    }

    @Override
    public void clear(){
        for(int i = 0; i<size; i++){
            //TODO
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
        /** TODO: implement*/

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
