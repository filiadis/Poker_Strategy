package sample.Combos;

import java.util.*;

public class StraightFlush {
    private Double prob = (1 - 0.000013);

    public StraightFlush() {
    }

    public Double getProb() {
        return prob;
    }

    public static String straightFlush(String card1, String card2, String card3, String card4, String card5) {

        String temp = "Nothing";

        List<String> foo = List.of(card1, card2, card3, card4, card5);

        List<Integer> freq = new ArrayList<>();

        List<Integer> foo2 = new ArrayList<>();

        List<String> foo3  = new ArrayList<>();

        for (String k : foo) {
            foo2.add(Integer.parseInt(k.substring(0,2)));
        }

        for (String h : foo) {
            foo3.add(h.substring(2,3));
        }

        Collections.sort(foo2);
        System.out.println(foo2);

        Set<String> distinct = new HashSet<>(foo3);
        for (String s : distinct) {
            freq.add(Collections.frequency(foo3, s));
        }

        System.out.println(freq);

        int count = 0;

        if (freq.get(0) == 5) {
            count = 1;
        }


        if ((foo2.get(0) == 1) && (count == 1)){
            if (((foo2.get(1)) == 10) &&
                    ((foo2.get(2)) == 11) &&
                    ((foo2.get(3)) == 12) &&
                    ((foo2.get(4)) == 13)) {
                temp = "Royal Flush";
            }else if (((foo2.get(1) - foo2.get(0)) == 1) &&
                    ((foo2.get(2) - foo2.get(1)) == 1) &&
                    ((foo2.get(3) - foo2.get(2)) == 1) &&
                    ((foo2.get(4) - foo2.get(3)) == 1)){
                temp = "Straight Flush";
            }
        }
        else if (((foo2.get(1) - foo2.get(0)) == 1) &&
                ((foo2.get(2) - foo2.get(1)) == 1) &&
                ((foo2.get(3) - foo2.get(2)) == 1) &&
                ((foo2.get(4) - foo2.get(3)) == 1) &&
                (count == 1)){
            temp = "Straight Flush";
        }
        else {
            temp = "Nothing";
        }

        return temp;
    }
}
