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

    /***********************************************
     * Calculate coin count by first determining   *
     * whether the input amount is divisable by 25.*
     * Then a dime and finally a nickel. Then add  *
     * the final remainder to the total coin count *
     ***********************************************/
    int getCoinCount(int change)
    {
        int dollar = 100;
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int dollarCount = 0;
        int nickelCount = 0;
        int dimeCount = 0;
        int quarterCount = 0;
        int totCoins = 0;
        int remainder = 0;

        if (change >= dollar)
        {
            dollarCount = change / dollar;
            totCoins += dollarCount;
            remainder = change % dollar;
        }


        if (dollarCount > 0 && remainder >= quarter)
        {
            quarterCount = remainder / quarter;
            totCoins += quarterCount;
            remainder = remainder % quarter;
        }
        else
        if (dollarCount == 0 && change >= quarter)
        {
            quarterCount = change / quarter;
            totCoins += quarterCount;
            remainder = change % quarter;
        }

        if (quarterCount > 0 && remainder >= dime)
        {
            dimeCount = remainder / dime;
            totCoins += dimeCount;
            remainder = remainder % dime;
        }
        else
        if (quarterCount == 0 && change >= dime)
        {
            dimeCount = change / dime;
            totCoins += dimeCount;
            remainder = change % dime;
        }


        if ((dimeCount > 0 || quarterCount > 0) && remainder >= nickel)
        {
            nickelCount = remainder / nickel;
            totCoins += nickelCount;
            remainder = remainder % nickel;
        }
        else
        if ((dimeCount == 0 && quarterCount == 0) && change >= nickel)
        {
            nickelCount = change / nickel;
            totCoins += nickelCount;
            remainder = change % nickel;
        }

        if (change < 5)
            totCoins = change;
        else
            totCoins += remainder;


        return totCoins;

    }
}