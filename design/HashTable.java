import java.util.Iterator;
import java.util.LinkedList;

public class HashTable {
    private final LinkedList<Tuple>[] table;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.table = new LinkedList[100007];
        for (int i = 0; i < table.length; i++) {
            this.table[i] = new LinkedList<Tuple>();
        }
    }

    public void put(int key, int val) {
        int pos = hash(key);
        LinkedList<Tuple> elements = this.table[pos];
        Iterator<Tuple> it = elements.iterator();
        while (it.hasNext()) {
            Tuple t = it.next();
            if (t.key == key) {
                t.val = val;
                return;
            }
        }
        Tuple p = new Tuple(key, val);
        elements.add(p);
    }

    public int get(int key) {
        int pos = hash(key);
        LinkedList<Tuple> eles = this.table[pos];
        for (int i = 0; i < eles.size(); i++) {
            Tuple p = eles.get(i);
            if (p.key == key)
                return p.val;
        }
        return -1;
    }

    public void remove(int key) {
        int pos = hash(key);
        LinkedList<Tuple> eles = this.table[pos];
        Iterator<Tuple> it = eles.iterator();
        while (it.hasNext()) {
            Tuple p = it.next();
            if (p.key == key)
                it.remove();
        }
    }

    private int hash(int key) {
        return key % 100007;
    }
}

class Tuple {
    int key;
    int val;

    Tuple(int key, int val) {
        this.key = key;
        this.val = val;
    }

}
