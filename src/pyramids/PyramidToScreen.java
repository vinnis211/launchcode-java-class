package pyramids;

import java.util.Scanner;

/**
 * Created by omx on 5/10/2015.
 */
public class PyramidToScreen {

    public PyramidToScreen() {

        Pyramid pyramid = new Pyramid();
        String outString = pyramid.build();
        System.out.print(outString);

    }
}
