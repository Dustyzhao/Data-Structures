/**
 * 定义接口Map，支持泛型
 * @author DUSTY
 */
public interface Map<K,V> {

    void add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    /**
     *赋值/更新值操作
     */
    void set(K key,V newValue);
    int getSize();
    boolean isEmpty();
}
