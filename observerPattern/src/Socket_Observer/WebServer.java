package Socket_Observer;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

public class WebServer implements newObservable {

    DataInputStream dis;
    private ServerSocket server;
    private Socket socket;
    ArrayList<newObserver> observers = new ArrayList<>();

    private final Logger logger = Logger.getLogger("log");

    public static void main(String[] args){
        while(true){
            try{
                System.out.println("Server Started.");

                new WebServer().newSubscription();
            }
            catch (Exception e){
                e.getMessage();
            }
        }
    }

    public void newSubscription() throws Exception{

        server = new ServerSocket(4362);

        while(true){
            try{
                socket = server.accept();
                logger.info("New user has subscribed.");
                Subscription subscription = null;
                subscription = new Subscription(socket,this);
                subscription.start();
            }
            catch (Exception e){
                throw new Error(e);
            }

        }
    }

    @Override
    public void add(newObserver obs) {
        observers.add(obs);
    }

    @Override
    public void remove(newObserver obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyEveryone(String m) {
        for(newObserver obs: observers){
            try{
                obs.update(m);
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}