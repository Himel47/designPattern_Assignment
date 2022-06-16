package Coordinate_Scenario;

import java.util.Arrays;
import java.util.logging.Logger;

public class twoDimension implements Chain {

    Logger logger = Logger.getLogger("Info");

    private Chain nextInChain;

    @Override
    public void setNext(Chain c) {
        this.nextInChain=c;
    }

    @Override
    public void process(Dimension request) {
        if(request.getCoordinate().length==2){
            System.out.println("==> Two Dimension Coordinates: "+ Arrays.toString(request.getCoordinate()));
            logger.info("2nd Layer");
            nextInChain.process(request);
        }
        else if(request.getCoordinate().length==3){
                System.out.println("    More than Two Dimension and WARNING Showed.");
                logger.warning("2nd Layer Passed with 3rd Layer, WARNING.");
                nextInChain.process(request);
        }
    }
}
