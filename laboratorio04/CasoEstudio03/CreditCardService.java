package CasoEstudio03;

public interface CreditCardService extends java.rmi.Remote {
    public ServerResponse sum(int a, int b) throws java.rmi.RemoteException;
}