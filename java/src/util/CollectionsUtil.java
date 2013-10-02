package util;

import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;


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
     * Returns the maximum int in the array. Requires a non-empty array.
     * @param nums
     * @return
     */
    public static int maxInt(int[] nums) {
        return Ints.max(nums);
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
    
    /**
     * Returns the minimum long in the collection. Requires a non-empty collection.
     * @param nums
     * @return
     */
    public static long minLong(Collection<Long> nums) {
        if (nums.size() == 0) {
            throw new IllegalArgumentException("Empty collection passed to max");
        }
        long min = nums.iterator().next();
        for (long i : nums) {
            min = Math.min(i, min);
        }
        return min;
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
    
    public static int sum(Collection<Integer> nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
    
    public static List<Integer> getTrueIndices(boolean[] array) {
        return getTrueIndices(array, 0, array.length - 1);
    }
    
    public static List<Integer> getTrueIndices(boolean[] array, int start, int end) {
        List<Integer> list = Lists.newArrayList();
        for (int i = start; i <= end; i++) {
            if(array[i]) {
                list.add(i);
            }
        }
        return list;
    }
    
    public static List<Integer> getTrueIndices(BitSet bitset, int start, int end) {
        List<Integer> list = Lists.newArrayList();
        for (int index = bitset.nextSetBit(start); index >=0 && index <= end; index = bitset.nextSetBit(index+1)) {
            list.add(index);
        }
        return list;
    }
    
    public static <E> Set<Set<E>> combinations(List<E> list, int size) {
        Set<Set<E>> ret = Sets.newHashSet();
        if (size == 0) {
            return ret;
        } else if (size == 1) {
            for (E e : list) {
                Set<E> s = Sets.newHashSet();
                s.add(e);
                ret.add(s);
            }
            return ret;
        } else {
            for (int i = 0; i < list.size(); i++) {
                E e = list.remove(i);
                Set<Set<E>> r = combinations(list, size - 1);
                for (Set<E> s : r) {
                    s.add(e);
                    ret.add(s);
                }
                list.add(i, e);
            }
            return ret;
        }
        
    }
    
    
}
