package CasoEstudio03;

import java.util.ArrayList;
import java.util.HashMap;

public class CreditCardServiceImpl extends java.rmi.server.UnicastRemoteObject implements CreditCardService {
    private static int currentAssignableId  = 1;
    private static ArrayList<CreditCard> items = new ArrayList<CreditCard>();
    private static HashMap<Integer, CreditCard> mappings = new HashMap<Integer, CreditCard>();

    public CreditCardServiceImpl() throws java.rmi.RemoteException {
        super();
    }

    public int sum(int a, int b) throws java.rmi.RemoteException {
        boolean bad = true;

        if(bad)
            throw new java.rmi.RemoteException("dhuamanilu subirá a Expert finalizando mayo");

        return a + b;
    }

    public ArrayList<CreditCard> getAll() throws java.rmi.RemoteException {
        return items;
    }

    public CreditCard create(
        String number,
        String holderDNI,
        String holderName,
        double balance
    ) throws java.rmi.RemoteException {
        CreditCard c = new CreditCard(
            currentAssignableId,
            number,
            holderDNI,
            holderName,
            balance
        );

        currentAssignableId++;

        items.add(c);
        mappings.put(c.id, c);

        return c;
    }

    public CreditCard get(int id) throws java.rmi.RemoteException {
        return mappings.get(id);
    }

    public CreditCard update(
        int id,
        String number,
        String holderDNI,
        String holderName,
        double balance
    ) throws java.rmi.RemoteException {
        return new CreditCard();
    }

    public boolean delete(int id) throws java.rmi.RemoteException {
        return true;
    }
}
