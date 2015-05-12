/**
 * Created by omx on 5/10/2015.
 */
import pyramids.pyramidToFile;
import pyramids.pyramidToScreen;

import java.util.Scanner;

public class mario{

    public static void main(String[] args) {

        String outputType = getOutputType();

        switch (outputType) {
            case "S":
            case "s":
                pyramidToScreen s_pyramid = new pyramidToScreen();
                s_pyramid.build();
                break;
            case "F":
            case "f":
                pyramidToFile f_pyramid = new pyramidToFile();
                f_pyramid.build();
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