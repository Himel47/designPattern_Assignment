package Socket_Observer;

public interface newObservable {
    public void add(newObserver newObserver);
    public void remove(newObserver newObserver);
    public void notifyEveryone(String msg);
    public void uploadSRC(String title);
}
