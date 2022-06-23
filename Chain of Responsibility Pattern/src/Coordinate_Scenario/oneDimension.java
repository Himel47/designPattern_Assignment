package Coordinate_Scenario;

import java.util.Arrays;
import java.util.logging.*;

public class oneDimension implements Chain {

    Logger logger = Logger.getLogger("Info");

    private Chain nextInChain;

    @Override
    public void setNext(Chain c) {
        this.nextInChain=c;
    }

    @Override
    public void process(Dimension request) {
        if(request.getCoordinate().length==1){
            System.out.println("==> One Dimension Coordinate: "+ Arrays.toString(request.getCoordinate()));
            logger.info("1st Layer");
        }
        else if(request.getCoordinate().length==2){
            System.out.println("    More than One Dimension and WARNING showed.");
            logger.warning("1st Layer Passed with 2nd Layer, WARNING.");
        }
        else if(request.getCoordinate().length==3){
            System.out.println("    More than One Dimension and SEVERE showed.");
            logger.severe("1st Layer Passed with 2nd Layer and 3rd Layer, SEVERE.");
        }
    }
}
