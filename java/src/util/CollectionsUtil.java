package util;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;


public class CollectionsUtil {
    /**
     * Returns the maximum int in the collection. Requires a non-empty collection.
     * @param nums
     * @return
     */
    public static int maxInt(Collection<Integer> nums) {
        if (nums.size() == 0) {
            throw new IllegalArgumentException("Empty collection passed to max");
        }
        int max = nums.iterator().next();
        for (int i : nums) {
            max = Math.max(i, max);
        }
        return max;
    }
    
    /**
     * Returns the maximum long in the collection. Requires a non-empty collection.
     * @param nums
     * @return
     */
    public static long maxLong(Collection<Long> nums) {
        if (nums.size() == 0) {
            throw new IllegalArgumentException("Empty collection passed to max");
        }
        long max = nums.iterator().next();
        for (long i : nums) {
            max = Math.max(i, max);
        }
        return max;
    }
    
    public static <E> Multiset<E> combinedMax(Multiset<E> one, Multiset<E> two) {
        Multiset<E> set = HashMultiset.create();
        for (E e : one.elementSet()) {
            set.setCount(e, Math.max(one.count(e), two.count(e)));
        }
        for (E e : two.elementSet()) {
            set.setCount(e, Math.max(one.count(e), two.count(e)));
        }
        return set;
    }
    
    
}
