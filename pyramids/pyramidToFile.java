package pyramids;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by omx on 5/10/2015.
 */
public class pyramidToFile extends Pyramid {
    int height;


    public pyramidToFile() {
        height = getHeight();
    }

    public int getHeight() {

        Scanner in = new Scanner(System.in);
        int inputHeight;

        do {
            System.out.print("Enter Pyramid Height: ");
            inputHeight = in.nextInt();
        } while (inputHeight < 0 || inputHeight > 23);

        return inputHeight;

    }

    public void build() {
        ArrayList<String> list = new ArrayList<String>();
        PrintWriter oFile = null;
        try {
            oFile = new PrintWriter("mario.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int maxcol = height + 1;
        int i;
        int s = maxcol;
        int spaceLooper;
        int sharpLooper;
        String row = "";
        list.add(row);


        for (i = 2; i <= maxcol; i++)

        {
            spaceLooper = s - 2;

            while (spaceLooper > 0) {
                list.add(" ");
                spaceLooper--;

            }
            s--;


            sharpLooper = i;
            while (sharpLooper > 0) {

                list.add("#");
                sharpLooper--;

            }

            list.add("\n");

        }

        String listString = "";

        for (String l : list)
        {
            listString += l ;
        }

        if (oFile != null) {
            oFile.println(listString);
        }
        oFile.close();
    }
}