package sample.Combos;

import java.util.*;

public class FourOfAKind {

    private Double prob = (1 - 0.00024);

    public FourOfAKind() {
    }

    public Double getProb() {
        return prob;
    }

    public static String fourOfAKind(String card1, String card2, String card3, String card4, String card5) {

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


        if ((freq.contains(4)) && (freq.contains(1))) {
            return "Four Of A Kind";
        } else {
            return "Nothing";
        }
    }
}
