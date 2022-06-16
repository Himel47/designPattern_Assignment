package Coordinate_Scenario;


public class Client {

    public static void main(String[] args) {
        Chain chain1 = new oneDimension();
        Chain chain2 = new twoDimension();
        Chain chain3 = new threeDimension();

        chain3.setNext(chain2);
        chain2.setNext(chain1);

        chain1.process(new Dimension(5));
        chain3.process(new Dimension(5,3,6));
        chain2.process(new Dimension(5,9));


    }
}
