package pyramids;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by omx on 5/10/2015.
 */
public class PyramidToFile {

    public PyramidToFile() {
        PrintWriter oFile = null;
        try {
            oFile = new PrintWriter("Mario.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Pyramid pyramid = new Pyramid();
        String outString = pyramid.build();

        if (oFile != null) {
            oFile.println(outString);
        }
        oFile.close();

    }
}