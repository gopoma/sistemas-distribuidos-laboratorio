package CasoEstudio03;

public class CreditCardServiceImpl extends java.rmi.server.UnicastRemoteObject implements CreditCardService {
    public CreditCardServiceImpl() throws java.rmi.RemoteException {
        super();
    }

    public ServerResponse sum(int a, int b) throws java.rmi.RemoteException {
        return new ServerResponse(true, a + b);
    }
}
