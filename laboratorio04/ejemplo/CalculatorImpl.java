package laboratorio04.ejemplo;
public class CalculatorImpl extends java.rmi.server.UnicastRemoteObject implements Calculator {

    // Implementations must have an explicit constructor
    // in order to declare the RemoteException exception
    public CalculatorImpl() throws java.rmi.RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws java.rmi.RemoteException {
        return a + b;
    }

    @Override
    public int sub(int a, int b) throws java.rmi.RemoteException {
        return a - b;
    }

    @Override
    public int mul(int a, int b) throws java.rmi.RemoteException {
        return a * b;
    }

    @Override
    public int div(int a, int b) throws java.rmi.RemoteException {
        return a / b;
    }
}
