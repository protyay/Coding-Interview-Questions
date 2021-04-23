import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDelGetRand_01_LC380 {
    /** Initialize your data structure here. */
    private final Map<Integer, Integer> valIdxMap;
    private int index;
    private final List<Integer> values;
    private final Random rand;

    public InsertDelGetRand_01_LC380() {
        this.valIdxMap = new HashMap<>();
        this.index = 0; // This will keep track of the next index to insert
        this.values = new ArrayList<>();
        this.rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (this.valIdxMap.containsKey(val))
            return false;

        this.values.add(val);
        this.valIdxMap.put(val, index++);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (!this.valIdxMap.containsKey(val))
            return false;
        // Take the last element from the list and swap it with the index of the val
        int removeIndex = this.valIdxMap.get(val);

        // Take the last element of the list and place it in the index that is to be
        // removed
        this.values.set(removeIndex, this.values.get(this.index - 1));

        // Update the corresponding entry in the valIdxMap
        this.valIdxMap.put(this.values.get(this.index - 1), removeIndex);

        this.valIdxMap.remove(val);
        this.values.remove(this.index - 1);

        this.index--;
        return true;
    }

    /**
     * Get a random element from the set. If it wasn't for this getRandom we would
     * NOT need to instantiate a LIST We could pretend we have a list, with some
     * arbit index.
     */
    public int getRandom() {
        int randIndex = rand.nextInt(this.index);
        return this.values.get(randIndex);
    }
}
/**
 * Many design problem(s) can actually be solved using two data-structures. A
 * primary , say a List or a DLL or LinkedList, whichever may be the case and a
 * HashMap. HashMap provides constant look-up time - O(1)
 */
