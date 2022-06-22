package Socket_Observer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Subscription extends Thread implements newObserver {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String subName;
    private newObservable server;

    public Subscription(Socket socket, WebServer webServer) throws Exception{
        this.socket = socket;
        this.server = webServer;
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    public void Message(String msg) throws Exception{
        dos.writeUTF(msg);
        dos.flush();
    }

    @Override
    public void run() {
        try{
            subName = dis.readUTF();
            String message = "New user "+subName+" has Subscribed.";
            server.notifyEveryone(message);
            server.add(this);
            System.out.println(message);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(String msg) throws Exception {
        Message(msg);
    }
}
