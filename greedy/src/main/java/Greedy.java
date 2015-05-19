/**
 * Created by omx on 5/17/2015.
 */
public class Greedy {

    public static void main (String[] varArgs) {

        CoinCalculator coinCalculator = new CoinCalculator();
        int change = coinCalculator.getValidChange();
        int changeCoint = coinCalculator.getCoinCount(change);
        System.out.print("Coin count = " + changeCoint);
    }

}

