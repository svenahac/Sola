import com.google.gson.Gson;

public class Message {
    Protocol protocol;
    String   body;
    String signature;
    String signer;
    public Message(Protocol protocol, String body) {
        this.protocol = protocol;
        this.body     = body;
    }

    public void print() {
        System.out.println(Constants.COMM + new Gson().toJson(this));
    }
}
