package pyramids;

import java.util.Scanner;

/**
 * Created by omx on 5/10/2015.
 */
public class pyramidToScreen implements printablePyramid{
    int height;

    public pyramidToScreen() {
        height = getHeight();
    }

    public int getHeight(){

        Scanner in = new Scanner(System.in);

        int inputHeight;
        do
        {
            System.out.print("Enter Pyramid Height: ");
            inputHeight = in.nextInt();
        }  while (inputHeight < 0 || inputHeight > 23);

        return inputHeight;

    }

    public void build(){
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
                System.out.print(" ");
                spaceLooper--;

            }
            s--;


            sharpLooper = i;
            while (sharpLooper > 0)
            {

                System.out.print("#");
                sharpLooper--;

            }

            System.out.print("\n");

        }
    }

}
