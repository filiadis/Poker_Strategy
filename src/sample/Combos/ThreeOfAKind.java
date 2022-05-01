package sample.Combos;

import java.math.BigDecimal;
import java.util.*;

public class ThreeOfAKind {

    private Double prob = (1 - 0.021);

    public ThreeOfAKind() {
    }

    public Double getProb() {
        return prob;
    }

    public static String threeOfAKind(String card1, String card2, String card3, String card4, String card5) {

        List<Integer> freq = new ArrayList<>();

        List<String> foo = List.of(card1, card2, card3, card4, card5);

        List<String> foo2 = new ArrayList<>();

        for (String k : foo) {
            foo2.add(k.substring(0,2));
        }

        Set<String> distinct = new HashSet<>(foo2);
        for (String s : distinct) {
            freq.add(Collections.frequency(foo2, s));
        }

        int count = 0;

        for (int n : freq) {
            if (n == 3) {
                count++;
            }
        }
        if (count == 1) {
            return "Three of a kind";
        } else {
            return "Nothing";
        }
    }

}
