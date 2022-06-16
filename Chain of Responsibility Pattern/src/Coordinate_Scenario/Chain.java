package Coordinate_Scenario;

public interface Chain {

    abstract void setNext(Chain nextInChain);
    abstract void process(Dimension request);
}
