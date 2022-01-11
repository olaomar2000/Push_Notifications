public class MessageUtil {
    private String message;

    public MessageUtil(String message) {
        this.message = message;
    }

    public String printMessage(){
        System.out.println(message);
        return message;
    }

    public String welcomeMessage(){
        message = "Hi! "+ message;
        System.out.println(message);
        return message;
    }
}