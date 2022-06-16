package socket_Scenario;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebsiteServer implements Observable{

    private List<Observer> observers = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);
    static ServerSocket server;

    public WebsiteServer(ServerSocket serverSocket){
        this.server = serverSocket;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4362);
        System.out.println("Server Started.");

        WebsiteServer server1 = new WebsiteServer(serverSocket);
        try{
            while(!serverSocket.isClosed()){
                Socket socket1 = serverSocket.accept();
                System.out.println("New Client Connected.");
                ClientHandler clientHandler = new ClientHandler(socket1);
                Thread thread = new Thread((Runnable) clientHandler);
                thread.start();


            }
        }
        catch (IOException e){

        }

    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAll(Message m) {
        for(Observer observe: observers){
            observe.update(m);
        }
    }
}
