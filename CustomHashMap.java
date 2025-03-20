import java.util.*;

class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private List<Entry<K, V>> buckets;
    private int size;

    public CustomHashMap() {
        buckets = new ArrayList<>(Collections.nCopies(INITIAL_CAPACITY, null));
        size = 0;
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % INITIAL_CAPACITY;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> head = buckets.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; // Update existing key
                return;
            }
            head = head.next;
        }

        Entry<K, V> newNode = new Entry<>(key, value);
        newNode.next = buckets.get(index);
        buckets.set(index, newNode);
        size++;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> head = buckets.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> head = buckets.get(index);
        Entry<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets.set(index, head.next);
                } else {
                    prev.next = head.next;
                }
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println("Value for key 'two': " + map.get("two"));
        map.remove("two");
        System.out.println("Contains key 'two': " + map.containsKey("two"));
        System.out.println("Size: " + map.size());
    }
}
