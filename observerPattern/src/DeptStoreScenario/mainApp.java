package DeptStoreScenario;

import java.io.*;
import java.util.Scanner;

import static DeptStoreScenario.Event.*;

public class mainApp {
    public static void main(String[] args) throws IOException {
        Store store = new Store();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String response ="";

        while(true){
            System.out.println("Wanna Subscribe or Unsubscribe?\nType BREAK to break");
            response= br.readLine();
            if(response.equalsIgnoreCase("break")){break;}
            String email, userName,res;
            if(response.equalsIgnoreCase("subscribe")){
                System.out.println("Notified by email or message?");
                res= br.readLine();
                System.out.println("Nofication for 1. new Item, or \n2. Sale Promotion?");
                int num = sc.nextInt();
                if(res.equalsIgnoreCase("email")){
                    System.out.print("Provide Email: ");
                    email= br.readLine();
                    if(num==1) {
                        store.getNotifyService().subscribe(New_item, new notifyEmailListener(email));
                    }
                    else{
                        store.getNotifyService().subscribe(Sale, new notifyEmailListener(email));
                    }
                }
                else{
                    System.out.println("Provide Your Name: ");
                    userName= br.readLine();
                    if(num==1){
                        store.getNotifyService().subscribe(New_item, new notifyMobileListener(userName));
                    }
                    else{
                        store.getNotifyService().subscribe(Sale, new notifyMobileListener(userName));
                    }
                }
            }
            else{
                System.out.println("Notified by email or message?");
                res= br.readLine();
                System.out.println("Nofication for 1. new Item, or \n2. Sale Promotion?");
                int num = sc.nextInt();
                if(res.equalsIgnoreCase("email")){
                    System.out.print("Provide Email: ");
                    email= br.readLine();
                    if(num==1) {
                        store.getNotifyService().unSubscribe(New_item, new notifyEmailListener(email));
                    }
                    else{
                        store.getNotifyService().unSubscribe(Sale, new notifyEmailListener(email));
                    }
                }
                else{
                    System.out.println("Provide Your Name: ");
                    userName= br.readLine();
                    if(num==1){
                        store.getNotifyService().unSubscribe(New_item, new notifyMobileListener(userName));
                    }
                    else{
                        store.getNotifyService().unSubscribe(Sale, new notifyMobileListener(userName));
                    }
                }
            }
            store.newItemPromotion();
            store.salePromotion();
        }
    }
}
