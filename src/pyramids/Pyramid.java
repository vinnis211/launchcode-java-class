package pyramids;

import java.util.Scanner;

/**
 * Created by omx on 5/16/2015.
 */
public class Pyramid {

    int height;

    public Pyramid() {
        height = getHeight();
    }

    public int getHeight(){

        Scanner in = new Scanner(System.in);

        int inputHeight;
        do
        {
            System.out.print("Enter Pyramid Height:  ");
            inputHeight = in.nextInt();
        }  while (inputHeight < 0 || inputHeight > 23);

        return inputHeight;

    }

    public String build(){
        StringBuilder pyramidString = new StringBuilder();
        int maxcol = height + 1;
        int i;
        int s = maxcol;
        int spaceLooper;
        int sharpLooper;
        String row = "";
        System.out.print(row);

        for(i = 2; i <= maxcol; i++)

        {
            spaceLooper = s - 2;

            while (spaceLooper > 0)
            {
                pyramidString.append(" ");
                spaceLooper--;

            }
            s--;


            sharpLooper = i;
            while (sharpLooper > 0)
            {

                pyramidString.append("#");
                sharpLooper--;

            }

            pyramidString.append("\n");

        }
        String p = pyramidString.toString();
        return p;
    }

}
