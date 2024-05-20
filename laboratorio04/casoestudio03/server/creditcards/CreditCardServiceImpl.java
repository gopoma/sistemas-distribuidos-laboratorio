import java.util.ArrayList;
import java.util.HashMap;

public class CreditCardServiceImpl extends java.rmi.server.UnicastRemoteObject implements CreditCardService {
    private static int currentAssignableId  = 1;
    private static ArrayList<CreditCard> items = new ArrayList<CreditCard>();
    private static HashMap<Integer, CreditCard> mappings = new HashMap<Integer, CreditCard>();

    public CreditCardServiceImpl() throws java.rmi.RemoteException {
        super();

        this.create(
            "12345678910111213",
            "71136033",
            "Gustavo Eduardo Ordoño Poma",
            25.50
        );

        this.create(
            "13121110987654321",
            "79797979",
            "Diego Alonso Huamani Luque",
            80.50
        );
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
        CreditCard c = new CreditCard(
            id,
            number,
            holderDNI,
            holderName,
            balance
        );

        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).id == id) {
                items.set(i, c);
            }
        }

        mappings.put(c.id, c);

        return c;
    }

    public boolean delete(int id) throws java.rmi.RemoteException {
        int tar_idx = -1;
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).id == id) {
                tar_idx = i;
            }    
        }

        mappings.remove(items.get(tar_idx).id);
        items.remove(tar_idx);

        return true;
    }
}
