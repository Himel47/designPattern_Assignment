package DeptStoreScenario;

import static DeptStoreScenario.Event.*;

public class Store {
    private final NotificationService notificationService;

    public Store() {
        notificationService = new NotificationService();
    }

    public void newItemPromotion(){
        notificationService.notifyCustomers(New_item);
    }

    public void salePromotion(){
        notificationService.notifyCustomers(Sale);
    }

    public NotificationService getNotifyService(){
        return notificationService;
    }

}
