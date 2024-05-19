package CasoEstudio03;

public class CreditCardServiceImpl extends java.rmi.server.UnicastRemoteObject implements CreditCardService {
    public CreditCardServiceImpl() throws java.rmi.RemoteException {
        super();
    }

    public ServerResponse sum(int a, int b) throws java.rmi.RemoteException {
        boolean bad = true;

        if(bad)
            throw new java.rmi.RemoteException("dhuamanilu subirá a Expert finalizando mayo");

        return new ServerResponse(true, a + b);
    }
}
