import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    private final int PORT = 1099;

    public Server() {
        try {
            CreditCardService c = new CreditCardServiceImpl();
            
            System.setProperty("java.rmi.server.codebase", "file:///.");
            System.setProperty("java.rmi.server.useCodebaseOnly", "true");
            
            //? LocateRegistry.createRegistry(PORT);
            System.setProperty("java.rmi.server.hostname", "192.168.1.13");
            Naming.rebind("rmi://192.168.1.13:" + PORT + "/CreditCardService", c);
        } catch(Exception e) {
            System.out.println("Trouble: ");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
