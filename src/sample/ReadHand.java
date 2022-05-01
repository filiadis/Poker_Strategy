package sample;

import java.util.ArrayList;
import java.util.List;

public class ReadHand {

    private List<String> card01;
    private List<String> card02;
    private List<String> op_1;
    private List<String> op_2;
    private List<String> op_3;
    private List<String> op_4;
    private List<String> op_5;
    private List<String> op_6;
    private List<String> op_7;
    private List<String> op_8;



    public List<String> reading(List<List<String>> list, int index){

        List<String> foo = new ArrayList<>();

        for (int i=1;i<list.size();i++){

            foo.add(list.get(i).get(index));

        }
        return foo;

    }
}
