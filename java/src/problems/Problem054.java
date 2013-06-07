package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.TreeMultiset;

public class Problem054 implements Problem {
    @Override
    public String solve() {
        List<Hand> oneHands = Lists.newArrayList();
        List<Hand> twoHands = Lists.newArrayList();
        Scanner scanner;
        try {
            scanner = new Scanner(new File("Problem054.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            String[] string = scanner.nextLine().split(" ");
            oneHands.add(new Hand(string, 0));
            twoHands.add(new Hand(string, 5));
        }
        return "" + solve(oneHands, twoHands);
    }
    
    private static int solve(List<Hand> oneHands, List<Hand> twoHands) {
        int wins = 0;
        for (int i = 0; i < oneHands.size(); i++) {
            Hand one = oneHands.get(i);
            Hand two = twoHands.get(i);
            if (one.compareTo(two) < 0) {
                wins++;
            } else {
            }
        }
        return wins;
    }

}

class Card implements Comparable<Card> {
    public static final char[] RANKS = new char[] {'-','-','2','3','4','5','6','7','8','9','T','J','Q','K','A'};
    public static final Map<Character, Integer> map = Maps.newHashMap();
    static {
        for (int i = 2; i <= 9; i++) {
            map.put(Character.forDigit(i,10), i);
        }
        map.put('T', 10); map.put('J', 11); map.put('Q', 12);map.put('K', 13); map.put('A', 14);
    }
    
    public final int rank;
    public final char suit;
    
    public Card(String string) {
        this.suit = string.charAt(1);
        this.rank = map.get(string.charAt(0));
    }
    
    @Override
    public int compareTo(Card other) {
        return 100 * (rank - other.rank) + (suit - other.suit);
    }
    
    @Override
    public String toString() {
        return "" + this.rank + this.suit;
    }
}

class Hand implements Comparable<Hand> {
    public final Card[] cards;
    public final TreeMultiset<Integer> ranks = TreeMultiset.create();
    public final int numDiffCards;
    
    public Hand(String[] strings, int startIndex) {
        this.cards = new Card[5];
        for (int i = startIndex; i < startIndex+5; i++) {
            cards[i-startIndex] = new Card(strings[i]);
        }
        Arrays.sort(cards);
        for (Card card : cards) {
            ranks.add(card.rank);
        }
        numDiffCards = ranks.elementSet().size();
        
    }
    
    public int flush() {
        if (cards[0].suit == cards[1].suit && cards[1].suit == cards[2].suit
                && cards[2].suit == cards[3].suit && cards[3].suit == cards[4].suit) {
            return cards[4].rank;
        } else {
            return -1;
        }
    }
    
    public int straight() {
        if (numDiffCards == 5) {
            int diff = cards[4].rank - cards[0].rank;
            if (diff == 4) {
                return cards[4].rank;
            } else if (diff == 12 && cards[4].rank == 14 && cards[3].rank == 5) {
                return 5;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
    
    public int getHighestCard(int numCards) {
        if (numDiffCards > 6 - numCards ) {
            return -1;
        }
        int maxRank = -1;
        for (int rank : ranks.elementSet()) {
            if (ranks.count(rank) == numCards) {
                maxRank = Math.max(rank, maxRank);
            }
        }
        return maxRank;
    }
    
    public int fullHouse() {
        if (numDiffCards == 2) {
            if (ranks.count(ranks.elementSet().first()) == 3) {
                return cards[0].rank;
            } else if (ranks.count(ranks.elementSet().last()) == 3) {
                return cards[4].rank;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
    
    @Override
    public int compareTo(Hand other) {
        int flush1 = flush();
        int flush2 = other.flush();
        int straight1 = straight();
        int straight2 = other.straight();
        int four1, four2;
        int fullHouse1, fullHouse2;
        int trips1, trips2;
        int twoPair1, twoPair2;
        int pair1, pair2;
        if (flush1 != -1 && flush2 != -1 && (straight1 != -1) == (straight2 != -1)) {
            return flush2 - flush1;
        } else if ((four1=getHighestCard(4)) != (four2=other.getHighestCard(4))) {
            return four2 - four1;
        } else if ((fullHouse1=fullHouse()) != (fullHouse2=other.fullHouse())) {
            return fullHouse2 - fullHouse1;
        } else if (flush1 != flush2) {
            return flush2 - flush1;
        } else if (straight1 != straight2) {
            return straight2 - straight1;
        } else if ((trips1=getHighestCard(3)) != (trips2=other.getHighestCard(3))) {
            return trips2-trips1;
        } else if ((twoPair1=twoPair()) != (twoPair2=other.twoPair())) {
            return twoPair2-twoPair1;
        } else if ((pair1=getHighestCard(2)) != (pair2=other.getHighestCard(2))) {
            return pair2 - pair1;
        } else {
            return compareHighCards(other);
        }
    }
    
    private int twoPair() {
        int[] pair = new int[2];
        int index = 0;
        for (int i = cards.length-2; i >= 0; i--) {
            if (cards[i].rank == cards[i+1].rank) {
                pair[index++] = cards[i].rank;
                i--;
            }
        }
        if (index == 2) {
            return pair[0]*15 + pair[1];
        } else {
            return -1;
        }
    }

    private int compareHighCards(Hand other) {
        for (int i = cards.length-1; i >=0; i--) {
            if (cards[i].rank != other.cards[i].rank) {
                return other.cards[i].rank - cards[i].rank;
            }
        }
        return 0;
    }
}


