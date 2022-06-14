package DeptStoreScenario;

import java.util.*;

public class NotificationService {
    private final Map<Event, List<storeListener>> customers;

    public NotificationService(){
        customers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event -> customers.put(event, new ArrayList<>()));
    }

    public void subscribe(Event eventType, storeListener listener){
        customers.get(eventType).add(listener);
    }

    public void unSubscribe(Event eventType, storeListener listener){
        if(customers.get(eventType).isEmpty()){
            System.out.println("No subscriber Yet");
        }
        else {
            customers.get(eventType).remove(listener);
        }
    }

    public void notifyCustomers(Event eventType){
        customers.get(eventType).forEach(listener -> listener.update(eventType));
    }

}
