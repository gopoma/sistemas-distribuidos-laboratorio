package creditcards;

import java.util.ArrayList;

public interface CreditCardService extends java.rmi.Remote {
    public int sum(int a, int b) throws java.rmi.RemoteException;

    public ArrayList<CreditCard> getAll() throws java.rmi.RemoteException;

    public CreditCard create(
        String num,
        String hDNI,
        String hName,
        double b
    ) throws java.rmi.RemoteException;

    public CreditCard get(int id) throws java.rmi.RemoteException;

    public CreditCard update(
        int id,
        String num,
        String hDNI,
        String hName,
        double b
    ) throws java.rmi.RemoteException;

    public boolean delete(int id) throws java.rmi.RemoteException;
}