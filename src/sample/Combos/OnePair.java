package sample.Combos;

import java.util.*;

public class OnePair {

    private Double prob = (1 - 0.422);

    public OnePair() {
    }

    public Double getProb() {
        return prob;
    }

    public static String onePair(String card1, String card2, String card3, String card4, String card5) {

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
            if (n == 2) {
                count++;
            }
        }
        if (count == 1) {
            return "One Pair";
        } else {
            return "Nothing";
        }
    }


}

