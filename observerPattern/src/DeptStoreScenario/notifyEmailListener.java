package DeptStoreScenario;

public record notifyEmailListener(String email) implements storeListener{

    @Override
    public void update(Event eventType) {
        System.out.println("==> Sending mail to " + email + " for "+ eventType);
    }
}
