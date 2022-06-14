package DeptStoreScenario;

public record notifyMobileListener(String userName) implements storeListener{

    @Override
    public void update(Event eventType) {
        System.out.println("==> Sending push notification to " + userName + " for "+ eventType);
    }
}
