package refactorings;

public class Messenger {
    private String message;

    public Messenger(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(getMessage());
    }

    public String getMessage() {
        if (message.isEmpty()){
            return "no message";
        }
        return message;
    }
}
