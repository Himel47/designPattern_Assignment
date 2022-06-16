package socket_Scenario;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Subscriber {

    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;
    private String Name;

    public Subscriber(Socket socket, String name ){
        try{
            this.socket = socket;
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.Name = name;
        }
        catch (IOException e){

        }
    }

    public void sendMessage(){
        try{
            bw.write(Name);
            bw.newLine();
            bw.flush();

            Scanner sc = new Scanner(System.in);
            while(socket.isConnected()){
                String messageSending = sc.nextLine();
                if(messageSending.equalsIgnoreCase("stop")){
                    socket.close();
                }
                bw.write(Name+": "+messageSending);
                bw.newLine();
                bw.flush();

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void MessageSeen(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String mesSent;
                while(socket.isConnected()){
                    try{
                        mesSent = br.readLine();
                        System.out.println(mesSent);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Client Name: ");
        System.out.println("\n");
        String userName = sc.nextLine();
        Socket socket = new Socket("localhost",4362);
        Subscriber subscriber = new Subscriber(socket,userName);

        subscriber.sendMessage();
        subscriber.MessageSeen();

    }


}
