package laboratorio04.ejemplo;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
public class CalculatorServer {
    public CalculatorServer() {
        try {
            // Inicia el registro RMI en el puerto 5000
            LocateRegistry.createRegistry(5000);
            // Crea una instancia del objeto remoto
            Calculator c = new CalculatorImpl();
            // Rebind el objeto remoto en el registro RMI con el nombre "CalculatorService"
            Naming.rebind("//localhost:5000/CalculatorService", c);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
    public static void main(String args[]) {
        new CalculatorServer();
    }
}