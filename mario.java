/**
 * Created by omx on 5/10/2015.
 */
import pyramids.Pyramid;
import pyramids.pyramidToFile;
import pyramids.pyramidToScreen;

import java.util.Scanner;

public class mario{

    public static void main(String[] args) {

        pyramidFactory pFactory = new pyramidFactory();
        Pyramid pyramid = null;
        String type = getOutputType();
        pyramid = pFactory.makePyramid(type);
        pyramid.build();
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