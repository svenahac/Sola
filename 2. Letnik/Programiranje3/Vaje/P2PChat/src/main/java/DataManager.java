import javax.naming.ldap.HasControls;
import java.util.HashMap;

public class DataManager {
    public HashMap<String, Client> clients;

    public DataManager() {
        this.clients = new HashMap<>();
    }
}
