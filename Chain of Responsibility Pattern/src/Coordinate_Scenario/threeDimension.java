package Coordinate_Scenario;

import java.util.Arrays;
import java.util.logging.Logger;

public class threeDimension implements Chain {

    Logger logger = Logger.getLogger("Info");

    private Chain nextInChain;

    @Override
    public void setNext(Chain c) {
        this.nextInChain=c;
    }

    @Override
    public void process(Dimension request) {
        if(request.getCoordinate().length==3){
            System.out.println("==> Three Dimension Coordinates: "+ Arrays.toString(request.getCoordinate()));
            logger.info("3rd Layer");
            nextInChain.process(request);
        }
    }
}
