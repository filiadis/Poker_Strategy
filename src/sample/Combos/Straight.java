package sample.Combos;

import java.util.*;

public class Straight {

    private Double prob = (1 - 0.0039);

    public Straight() {
    }

    public Double getProb() {
        return prob;
    }

    public static String straight(String card1, String card2, String card3, String card4, String card5) {

        String temp = "Nothing";

        List<String> foo = List.of(card1, card2, card3, card4, card5);

        List<Integer> foo2 = new ArrayList<>();

        for (String k : foo) {
            foo2.add(Integer.parseInt(k.substring(0,2)));
        }

        Collections.sort(foo2);


        if (foo2.get(0) == 1) {
            if (((foo2.get(1)) == 10) &&
                    ((foo2.get(2)) == 11) &&
                    ((foo2.get(3)) == 12) &&
                    ((foo2.get(4)) == 13)) {
                temp = "Straight";
            }else if (((foo2.get(1) - foo2.get(0)) == 1) &&
                    ((foo2.get(2) - foo2.get(1)) == 1) &&
                    ((foo2.get(3) - foo2.get(2)) == 1) &&
                    ((foo2.get(4) - foo2.get(3)) == 1)){
                temp = "Straight";
            }
        }
        else if (((foo2.get(1) - foo2.get(0)) == 1) &&
                ((foo2.get(2) - foo2.get(1)) == 1) &&
                ((foo2.get(3) - foo2.get(2)) == 1) &&
                ((foo2.get(4) - foo2.get(3)) == 1)){
            temp = "Straight";
        }
        else {
            temp = "Nothing";
        }
        return temp;
    }
}
