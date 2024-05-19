package CasoEstudio03;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    private final int PORT = 4000;

    public Server() {
        try {
            CreditCardService c = new CreditCardServiceImpl();
            
            Registry r = LocateRegistry.createRegistry(4000);
            Naming.rebind("rmi://localhost:" + PORT + "/CreditCardService", c);
        } catch(Exception e) {
            System.out.println("Trouble: ");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
