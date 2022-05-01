package sample;

import sample.Combos.*;

public class ComboCalculations {

    public String calculations(String card1, String card2, String card3, String card4, String card5){

        String temp;

        if (StraightFlush.straightFlush(card1,card2,card3,card4,card5) == "Royal Flush"){

            temp = "Royal Flush";

        } else if  (StraightFlush.straightFlush(card1,card2,card3,card4,card5) == "Straight Flush"){

            temp = "Straight Flush";

        } else if  (FourOfAKind.fourOfAKind(card1,card2,card3,card4,card5) == "Four Of A Kind"){

            temp = "Four Of A Kind";

        } else if  (FullHouse.fullHouse(card1,card2,card3,card4,card5) == "Full House"){

            temp = "Full House";

        } else if  (Flush.flush(card1,card2,card3,card4,card5) == "Flush"){

            temp = "Flush";

        } else if  (Straight.straight(card1,card2,card3,card4,card5) == "Straight") {

            temp = "Straight";

        } else if  (ThreeOfAKind.threeOfAKind(card1,card2,card3,card4,card5) == "Three of a kind") {

            temp = "Three of a kind";

        } else if  (TwoPairs.twoPairs(card1,card2,card3,card4,card5) == "Two Pairs") {

            temp = "Two Pairs";

        } else if  (OnePair.onePair(card1,card2,card3,card4,card5) == "One Pair") {

            temp = "One Pair";

        } else {

            temp = "No Pair / High Card";
        }

        return temp;

    }

}
