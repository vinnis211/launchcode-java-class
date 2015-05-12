import pyramids.Pyramid;
import pyramids.pyramidToFile;
import pyramids.pyramidToScreen;

/**
 * Created by omx on 5/11/2015.
 */
public class pyramidFactory {

    public Pyramid makePyramid(String pyramidType){
        Pyramid newPyramid = null;
        switch (pyramidType) {
            case "S":
            case "s":
                return new pyramidToScreen();
            case "F":
            case "f":
                return new pyramidToFile();
            default:
                return null;

        }
    }

}
