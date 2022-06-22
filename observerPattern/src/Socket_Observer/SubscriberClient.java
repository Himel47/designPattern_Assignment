package Socket_Observer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SubscriberClient {

    private Socket socket;
    private String userName;
    private DataInputStream dis;
    private DataOutputStream dos;

    public void initiate() throws Exception{
        socket = new Socket("localhost",4362);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        System.out.println("Welcome "+name+". Thanks for subscribing.");
        dos.writeUTF(name);
        readMessage();
    }

    public static void main(String[] args) throws IOException {

        while(true){
            try{
                new SubscriberClient().initiate();
            }
            catch (Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }

    private void readMessage() throws Exception{
        String message;
        while (true){
            try {
                message = dis.readUTF();
                System.out.println("Server: "+message);
            } catch (Exception e) {
                System.out.println("Error: \n==>"+e.getMessage());
                break;
            }
        }
    }

}
