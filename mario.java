package src; /**
 * Created by omx on 5/10/2015.
 */

import src.pyramids.PyramidToFile;
import src.pyramids.PyramidToScreen;

import java.util.Scanner;

public class Mario {

    public static void main(String[] args) {

        String outputType = getOutputType();

        switch (outputType) {
            case "S":
            case "s":
                PyramidToScreen s_pyramid = new PyramidToScreen();
                break;
            case "F":
            case "f":
                PyramidToFile f_pyramid = new PyramidToFile();
                break;
            default:
                break;

        }
    }

    /*****************************************
     * Request and store output optioon		 *
     *                                        *
     *****************************************/
    public static String getOutputType () {

        String outType = "";
        Scanner in2 = new Scanner(System.in);

        do
        {
            System.out.print("Output to (S)sreen or (F)file: ");
            outType = in2.next();
        }  while (!outType.equals("S") && !outType.equals("F") && !outType.equals("s") && !outType.equals("f"));

        return outType;

    }

}
