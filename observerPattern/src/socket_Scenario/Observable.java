package socket_Scenario;

public interface Observable {
    public void add(Observer observer);
    public void remove(Observer observer);
    public void notifyAll(Message m);
}
