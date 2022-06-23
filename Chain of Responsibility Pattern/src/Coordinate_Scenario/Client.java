package Coordinate_Scenario;


import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Chain chain1 = new oneDimension();
        Chain chain2 = new twoDimension();
        Chain chain3 = new threeDimension();

        chain3.setNext(chain2);
        chain2.setNext(chain1);

        System.out.println("Enter Dimension Count: 1,2 or 3? ");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        if(count==1){
            int a;
            System.out.print("Enter the Co-ordinate: ");
            a= sc.nextInt();
            chain1.process(new Dimension(a));
        }
        else if(count==2){
            int a,b;
            System.out.print("Enter First Co-ordinate: ");
            a= sc.nextInt();
            System.out.print("Enter Second Co-ordinate: ");
            b= sc.nextInt();

            chain2.process(new Dimension(a,b));
        }
        else{
            int a,b,c;
            System.out.print("Enter First Co-ordinate: ");
            a= sc.nextInt();
            System.out.print("Enter Second Co-ordinate: ");
            b= sc.nextInt();
            System.out.print("Enter Third Co-ordinate: ");
            c= sc.nextInt();
            chain3.process(new Dimension(a,b,c));
        }
    }
}
