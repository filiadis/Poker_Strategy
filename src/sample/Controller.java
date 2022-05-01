package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Combos.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    //Global variables

    //Opening hand lists
    public String noOfOps = "1";
    public List<String> card01;
    public List<String> card02;
    public List<String> op_1;
    public List<String> op_2;
    public List<String> op_3;
    public List<String> op_4;
    public List<String> op_5;
    public List<String> op_6;
    public List<String> op_7;
    public List<String> op_8;

    public List<String> flushes = List.of("d","s","h","c");


    public String card1;
    public String card2;
    public String card3;
    public String card4;
    public String card5;
    public String card6;
    public String card7;


    public double winningProbability = 0;

    public Integer openHandProb;

    public Integer bank = 1000;

    public Integer pot = 200;

    public Integer bet = 50;

    //FXMLs
    @FXML
    public ChoiceBox<String> cb;
    @FXML
    public TextField cardOne;
    @FXML
    public TextField cardTwo;
    @FXML
    public TextField cardThree;
    @FXML
    public TextField cardFour;
    @FXML
    public TextField cardFive;
    @FXML
    public TextField cardSix;
    @FXML
    public TextField cardSeven;
    @FXML
    public TextField bank1;
    @FXML
    public TextField pot1;
    @FXML
    public TextField bet1;
    @FXML
    public TextField comments;
    @FXML
    public Button newGame;
    @FXML
    public Button exit;
    @FXML
    public TextField winProb;
    @FXML
    public TextField EV;
    @FXML
    public TextField combination;
    @FXML
    public Button calculate;



    public void initialize() throws IOException {

        //Read hands_fin

        String path = "src/sample/pokerFiles/hands_fin.csv";

        List<List<String>> openingHand = new ReadFile().readData(path);

        //Populate lists for opening hands

        ReadHand rh = new ReadHand();

        card01 = rh.reading(openingHand, 1);
        card02 = rh.reading(openingHand, 2);
        op_1 = rh.reading(openingHand, 3);
        op_2 = rh.reading(openingHand, 4);
        op_3 = rh.reading(openingHand, 5);
        op_4 = rh.reading(openingHand, 6);
        op_5 = rh.reading(openingHand, 7);
        op_6 = rh.reading(openingHand, 8);
        op_7 = rh.reading(openingHand, 9);
        op_8 = rh.reading(openingHand, 10);

        comments.setText("");
        comments.setStyle("-fx-text-fill: green");

        winProb.setText("0");
        EV.setText("0");

        bank1.setText(bank.toString());
        pot1.setText(pot.toString());
        bet1.setText(bet.toString());

    }

    public void opponents() {

        noOfOps = cb.getValue();
    }

    public String findIndices() {

        String foo = null;

        for (int i = 0; i < card01.size(); i++) {

            if ((card01.get(i).equals(card1) && card02.get(i).equals(card2)) || (card01.get(i).equals(card2) && card02.get(i).equals(card1))) {

                if (noOfOps.equals("1")) {
                    foo = op_1.get(i);
                } else if (noOfOps.equals("2")) {
                    foo = op_2.get(i);
                } else if (noOfOps.equals("3")) {
                    foo = op_3.get(i);
                } else if (noOfOps.equals("4")) {
                    foo = op_4.get(i);
                } else if (noOfOps.equals("5")) {
                    foo = op_5.get(i);
                } else if (noOfOps.equals("6")) {
                    foo = op_6.get(i);
                } else if (noOfOps.equals("7")) {
                    foo = op_7.get(i);
                } else if (noOfOps.equals("8")) {
                    foo = op_8.get(i);
                } else {
                    foo = "No match";
                }
            }
        }
        return foo;
    }

    public void onBank(ActionEvent actionEvent) {
        if (actionEvent != null) {
            bank = Integer.parseInt(bank1.getText());

        }
        comments.setText("Bank set");
        comments.setStyle("-fx-text-fill: green");

    }

    public void onBet(ActionEvent actionEvent) {
        if (actionEvent != null) {
            bet = Integer.parseInt(bet1.getText());
        }
        comments.setText("Total Bet set");
        comments.setStyle("-fx-text-fill: green");

    }

    public void onPot(ActionEvent actionEvent) {
        if (actionEvent != null) {
            pot = Integer.parseInt(pot1.getText());
        }
        comments.setText("Total Pot set");
        comments.setStyle("-fx-text-fill: green");

    }

    //----------------Setting cards----------------//

    public void firstCard(ActionEvent actionEvent) {
        if (actionEvent != null) {
            if (cardOne.getText().length() != 3) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else if ((flushes.contains(cardOne.getText().substring(2,3))) == false) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else {
                card1 = cardOne.getText();
                comments.setText("1st card set");
                comments.setStyle("-fx-text-fill: green");
            }
        }
    }

    public void secondCard(ActionEvent actionEvent) {
        if (actionEvent != null) {
            if (cardTwo.getText().length() != 3) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else if ((flushes.contains(cardTwo.getText().substring(2,3))) == false) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else {
                card2 = cardTwo.getText();
                comments.setText("2nd card set");
                comments.setStyle("-fx-text-fill: green");
            }
        }
    }

    public void thirdCard(ActionEvent actionEvent) {
        if (actionEvent != null) {
            if (cardThree.getText().length() != 3) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else if ((flushes.contains(cardThree.getText().substring(2,3))) == false) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else {
                card3 = cardThree.getText();
                comments.setText("3rd card set");
                comments.setStyle("-fx-text-fill: green");
            }
        }
    }

    public void fourthCard(ActionEvent actionEvent) {
        if (actionEvent != null) {
            if (cardFour.getText().length() != 3) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else if ((flushes.contains(cardFour.getText().substring(2,3))) == false) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else {
                card4 = cardFour.getText();
                comments.setText("4th card set");
                comments.setStyle("-fx-text-fill: green");
            }
        }
    }

    public void fifthCard(ActionEvent actionEvent) {
        if (actionEvent != null) {
            if (cardFive.getText().length() != 3) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else if ((flushes.contains(cardFive.getText().substring(2,3))) == false) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else {
                card5 = cardFive.getText();
                comments.setText("5th card set");
                comments.setStyle("-fx-text-fill: green");
            }
        }
    }

    public void SixthCard(ActionEvent actionEvent) {
        if (actionEvent != null) {
            if (cardSix.getText().length() != 3) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else if ((flushes.contains(cardSix.getText().substring(2,3))) == false) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else {
                card6 = cardSix.getText();
                comments.setText("6th card set");
                comments.setStyle("-fx-text-fill: green");
            }
        }

    }

    public void SeventhCard(ActionEvent actionEvent) {
        if (actionEvent != null) {
            if (cardSeven.getText().length() != 3) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else if ((flushes.contains(cardSeven.getText().substring(2,3))) == false) {
                comments.setText("Invalid characters");
                comments.setStyle("-fx-text-fill: red");

            } else {
                card7 = cardSeven.getText();
                comments.setText("7th card set");
                comments.setStyle("-fx-text-fill: green");
            }
        }
    }

    public void calculation(ActionEvent actionEvent) {

        if ((card1 != null) && (card2 != null) && (card3 == null) &&
                (card4 == null) && (card5 == null) && (card6 == null) && (card7 == null)) {

            String foo = findIndices();

            winningProbability = Double.parseDouble(foo);

            winProb.setText(foo);

            try {
                openHandProb = Integer.parseInt(foo);
            } catch (Exception e) {
                comments.setText("No match");
                comments.setStyle("-fx-text-fill: red");
            }

            double foo2 = (double) openHandProb;

            double foo3 = foo2 / 100;

            double foo4 = ((foo3 * (pot - bet)) - ((1 - foo3) * bet));

            double foo5 = (((foo4 + bet) / bet) - 1) * 100;

            BigDecimal bd = new BigDecimal(foo5).setScale(2, RoundingMode.HALF_UP);

            EV.setText(bd.toString());

            if (bd.compareTo(BigDecimal.ZERO) < 0) {
                EV.setStyle("-fx-text-fill: red");
            } else {
                EV.setStyle("-fx-text-fill: green");
            }
        } else if ((card1 != null) && (card2 != null) && (card3 != null) &&
                (card4 != null) && (card5 != null) && (card6 == null) && (card7 == null)) {

            String calcs = new ComboCalculations().calculations(card1, card2, card3, card4, card5);

            double prob;

            switch (calcs) {
                case "Royal Flush":
                    prob = new StraightFlush().getProb();
                    break;
                case "Straight Flush":
                    prob = new StraightFlush().getProb();
                    break;
                case "Four Of A Kind":
                    prob = new FourOfAKind().getProb();
                    break;
                case "Full House":
                    prob = new FullHouse().getProb();
                    break;
                case "Flush":
                    prob = new Flush().getProb();
                    break;
                case "Straight":
                    prob = new Straight().getProb();
                    break;
                case "Two Pairs":
                    prob = new TwoPairs().getProb();
                    break;
                case "One Pair":
                    prob = new OnePair().getProb();
                    break;
                case "No Pair / High Card":
                    prob = 0.5;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + calcs);
            }

            //Set winning probability
            winningProbability = ((prob * winningProbability) * prob) / winningProbability;

            BigDecimal foo = new BigDecimal(winningProbability).setScale(2, RoundingMode.HALF_UP);

            winProb.setText(String.valueOf(foo));

            //Set EV
            double foo2 = ((winningProbability * (pot - bet)) - ((1 - winningProbability) * bet));

            double foo3 = (((foo2 + bet) / bet) - 1) * 100;

            BigDecimal bd = new BigDecimal(foo3).setScale(2, RoundingMode.HALF_UP);

            EV.setText(bd.toString());

            if (bd.compareTo(BigDecimal.ZERO) < 0) {
                EV.setStyle("-fx-text-fill: red");
            } else {
                EV.setStyle("-fx-text-fill: green");
            }

            combination.setText(calcs);

        } else if ((card1 != null) && (card2 != null) && (card3 != null) &&
                (card4 != null) && (card5 != null) && (card6 != null) && (card7 == null)) {

            String calcs = new ComboCalculations().calculations(card1, card2, card3, card4, card5);

            double prob;

            switch (calcs) {
                case "Royal Flush":
                    prob = new StraightFlush().getProb();
                    break;
                case "Straight Flush":
                    prob = new StraightFlush().getProb();
                    break;
                case "Four Of A Kind":
                    prob = new FourOfAKind().getProb();
                    break;
                case "Full House":
                    prob = new FullHouse().getProb();
                    break;
                case "Flush":
                    prob = new Flush().getProb();
                    break;
                case "Straight":
                    prob = new Straight().getProb();
                    break;
                case "Two Pairs":
                    prob = new TwoPairs().getProb();
                    break;
                case "One Pair":
                    prob = new OnePair().getProb();
                    break;
                case "No Pair / High Card":
                    prob = 0.5;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + calcs);
            }

        }
    }

    public void newGame(ActionEvent actionEvent) {
        card1 = null;
        card2 = null;
        card3 = null;
        card4 = null;
        card5 = null;

        cardOne.setText(null);
        cardTwo.setText(null);
        cardThree.setText(null);
        cardFour.setText(null);
        cardFive.setText(null);
        winProb.setText("0");
        EV.setText("0");
        pot = 200;
        bet = 50;
        pot1.setText(pot.toString());
        bet1.setText(bet.toString());
        comments.setText(null);
        combination.setText(null);
    }

    public void exitApp(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }
}

