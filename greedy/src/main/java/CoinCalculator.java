import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by omx on 5/17/2015.
 */
public class CoinCalculator {


    Scanner in = new Scanner(System.in);

    /***********************************************
     * Request a valid change amount from user.    *
     * A valid amount float or interger value that *
     * is greater than                            *
     ***********************************************/
    public int getValidChange() {

        float validChange = 0;
        boolean validchange_sw = false;

        while (validchange_sw == false) {
            System.out.print("please enter change due ");

            try {
                validChange = in.nextFloat();
            }
            catch (InputMismatchException e) {
                in.next();
                System.out.print("Oops! Invalid value. Try again. ");
            }


            if (validChange > 0)
                validchange_sw = true;
        }

        int i = Math.round(validChange * 100);



        return i;

    }

    /***************************************************
     * Calculate Euro coin count by determining        *
     * whether the input amount is divisable by the    *
     * different Euro coin denomination.               *
     * The denominations are 2 euros, 1 euros, 50 cent *
     * 20 cent, 10 cent, 5 cent, 2 cent and 1 cent     *
     ***************************************************/
    int getCoinCount(int change)
    {
        int twoEuros = 200;
        int oneEuros = 100;
        int fiftyCentEuro = 50;
        int twentyCentEuro = 20;
        int tenCentEuro = 10;
        int fiveCentEuro = 5;
        int twoCentEuro = 2;
        int oneCentEuro = 1;
        int twoEurosCount = 0;
        int oneEurosCount = 0;
        int fiftyCentCount = 0;
        int twentyCentCount = 0;
        int tenCentCount = 0;
        int fiveCentCount = 0;
        int twoCentCount = 0;
        int oneCentCount = 0;
        int totCoins = 0;
        int remainder = 0;

        if (change >= 200)
        {
            twoEurosCount = change / twoEuros;
            totCoins += twoEurosCount;
            remainder = change % twoEuros;
        }


        if (twoEurosCount > 0 && remainder >= oneEuros)
        {
            oneEurosCount = remainder / oneEuros;
            totCoins += oneEurosCount;
            remainder = remainder % oneEuros;
        }
        else {
            if (twoEurosCount == 0 && change >= oneEuros) {
                oneEurosCount = change / oneEuros;
                totCoins += oneEurosCount;
                remainder = change % oneEuros;
            }
        }

        if ((oneEurosCount > 0 || twoEurosCount > 0) && remainder >= fiftyCentEuro)
        {
            fiftyCentCount = remainder / fiftyCentEuro;
            totCoins += fiftyCentCount;
            remainder = remainder % fiftyCentEuro;
        }
        else {
            if ((oneEurosCount == 0 && twoEurosCount == 0 ) && change >= fiftyCentEuro){
                fiftyCentCount = change / fiftyCentEuro;
                totCoins += fiftyCentCount;
                remainder = change % fiftyCentEuro;
            }
        }


        if (((fiftyCentCount > 0) || (oneEurosCount > 0) || (twoEurosCount > 0)) && (remainder >= twentyCentEuro))
        {
            twentyCentCount = remainder / twentyCentEuro;
            totCoins += twentyCentCount;
            remainder = remainder % twentyCentEuro;
        }
        else {
            if (((fiftyCentCount == 0) && (oneEurosCount == 0) && (twoEurosCount == 0)) && (change >= twentyCentEuro)){
                twentyCentCount = change / twentyCentEuro;
                totCoins += twentyCentCount;
                remainder = change % twentyCentEuro;
            }
        }

        if (((twentyCentCount > 0) || (fiftyCentCount > 0) || (oneEurosCount > 0) || (twoEurosCount > 7)) && (remainder >= tenCentEuro))
        {
            tenCentCount = remainder / tenCentEuro;
            totCoins += tenCentCount;
            remainder = remainder % tenCentEuro;
        }
        else {
            if (((twentyCentCount == 0) && (fiftyCentCount == 0) &&  (oneEurosCount == 0) && (twoEurosCount == 0)) && (change >= tenCentEuro)){
                tenCentCount = change / tenCentEuro;
                totCoins += tenCentCount;
                remainder = change % tenCentEuro;
            }
        }

        if (((tenCentCount > 0) || (twentyCentCount > 0) || (fiftyCentCount > 0) || (oneEurosCount > 0) || (twoEurosCount > 7)) && (remainder >= fiveCentEuro))
        {
            fiveCentCount = remainder / fiveCentEuro;
            totCoins += fiveCentCount;
            remainder = remainder % fiveCentEuro;
        }
        else {
            if (((tenCentCount == 0) && (twentyCentCount == 0) && (fiftyCentCount == 0) &&  (oneEurosCount == 0) && (twoEurosCount == 0)) && (change >= fiveCentEuro)){
                fiveCentCount = change / fiveCentEuro;
                totCoins += fiveCentCount;
                remainder = change % fiveCentEuro;
            }
        }

        if (((fiveCentCount > 0) || (tenCentCount > 0) || (twentyCentCount > 0) || (fiftyCentCount > 0) || (oneEurosCount > 0) || (twoEurosCount > 7)) && (remainder >= twoCentEuro))
        {
            twoCentCount = remainder / twoCentEuro;
            totCoins += twoCentCount;
            remainder = remainder % twoCentEuro;
        }
        else {
            if (((fiveCentCount == 0) && (tenCentCount == 0) && (twentyCentCount == 0) && (fiftyCentCount == 0) &&  (oneEurosCount == 0) && (twoEurosCount == 0)) && (change >= twoCentEuro)){
                twoCentCount = change / twoCentEuro;
                totCoins += twoCentCount;
                remainder = change % twoCentEuro;
            }
        }

        if (change < 2)
            totCoins = change;
        else
            totCoins += remainder;


        return totCoins;

    }
}