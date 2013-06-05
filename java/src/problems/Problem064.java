package problems;

import java.util.List;
import java.util.Set;

import util.MathUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Problem064 implements Problem {
    public void solve() {
        int total = 0;
        for (int i = 1; i <= 10000; i++) {
            if ((Math.sqrt(i) % 1 > 0.00001)) {
                List<Value> sequence = getSequence(i);
                if (sequence.size() % 2 == 1) {
                    total++;
                }
            }
        }
        System.out.println(total);
    }
    
    public static List<Value> getSequence(int sqrt) {
        List<Value> values = Lists.newArrayList();
        Set<Value> set = Sets.newHashSet();
        Value value = new Value(1, sqrt, (int) Math.sqrt(sqrt), 1);
        while (!set.contains(value)) {
            values.add(value);
            set.add(value);
            value = value.getNextValue();
        }
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(value)) {
                return values.subList(i, values.size());
            }
        }
        throw new RuntimeException("This place in the code should never occur.");
    }
}

class Value {
    public int sqrt;
    public int subtr;
    public int denom;
    public int coeff;
    
    public Value(int coeff, int sqrt, int subtr, int denom) {
        this.coeff = coeff;
        this.sqrt = sqrt;
        this.subtr = subtr;
        this.denom = denom;
    }
    
    public int getInt() {
        return (int) (denom / (coeff * Math.sqrt(sqrt) - subtr));
    }
    
    public Value getNextValue() {
        int val = getInt();
        int nextDenom = coeff*coeff*sqrt - subtr*subtr;
        int nextCoeff = denom*coeff;
        int nextSubtr = denom*subtr;
        nextSubtr -= nextDenom * val;
        int gcd = MathUtil.gcd(nextDenom, MathUtil.gcd(nextCoeff, nextSubtr));
        nextDenom /= gcd;
        nextCoeff /= gcd;
        nextSubtr /= gcd;
        return new Value(nextCoeff, sqrt, -nextSubtr, nextDenom);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + coeff;
        result = prime * result + denom;
        result = prime * result + sqrt;
        result = prime * result + subtr;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Value other = (Value) obj;
        if (coeff != other.coeff)
            return false;
        if (denom != other.denom)
            return false;
        if (sqrt != other.sqrt)
            return false;
        if (subtr != other.subtr)
            return false;
        return true;
    }

}
