import java.util.Iterator;
import java.util.Set;

public class BSTMap<K, V> implements Map61B<K, V>{

    /** Removes all of the mappings from this map. */
    @Override
    public void clear(){

    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key){
        return true;
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key){
        return null;
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size(){
        return 0;
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value){
        return;
    }




    /** not implementing */

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet(){
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator(){
        throw new UnsupportedOperationException();
    }

}
