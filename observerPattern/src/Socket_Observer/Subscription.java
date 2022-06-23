package Socket_Observer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Subscription extends Thread implements newObserver {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String subName;
    private newObservable server;
    Scanner sc = new Scanner(System.in);

    public Subscription(Socket socket, WebServer webServer) throws Exception{
        this.socket = socket;
        this.server = webServer;
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try{
            subName = dis.readUTF();
            server.add(this);
            String message = "New user "+subName+" has Subscribed.";
            System.out.println(message);
            String serverMessage = sc.nextLine();
            server.uploadSRC(serverMessage);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(String msg) throws Exception {
        dos.writeUTF(msg);
        dos.flush();
    }
}
