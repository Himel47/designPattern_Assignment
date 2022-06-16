package socket_Scenario;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable, Observer{

    static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    public static WebsiteServer server ;
    private BufferedReader br;
    private BufferedWriter bw;
    private String clientName;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;

            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientName = br.readLine();
            clientHandlers.add(this);
            server.add(this);
            broadcastMessage(clientName+ " has entered.");

        } catch (IOException e) {

        }
    }

    public void broadcastMessage(String msg){
        for(ClientHandler clientHandler: clientHandlers){
            try{
                if (!clientHandler.clientName.equals(clientName)){
                    clientHandler.bw.write(msg);
                    clientHandler.bw.newLine();
                    clientHandler.bw.flush();}
            }catch (IOException e){

            }
        }

        Message message = new Message(msg);
        server.remove(this);
        server.notifyAll(message);
        server.add(this);

    }

    @Override
    public void run() {
        String ClientMessage;

        while (socket.isConnected()) {
            try {
                ClientMessage = br.readLine();
                System.out.println(ClientMessage);
                broadcastMessage(ClientMessage);

            } catch (IOException e) {
            }

        }
    }

    @Override
    public void update(Message message) {
        try{
            bw.write(message.getContent());
            bw.flush();
        }
        catch (IOException e){

        }
    }
}
