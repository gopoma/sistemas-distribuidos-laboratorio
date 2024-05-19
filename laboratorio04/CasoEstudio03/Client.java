package CasoEstudio03;

import java.rmi.Naming;
import java.rmi.RemoteException;

import CasoEstudio03.ServerResponse;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class Client {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        try {
            CreditCardService c = (CreditCardService) Naming.lookup("rmi://localhost:4000/CreditCardService");
            
            ServerResponse R = c.sum(num1, num2);
            System.out.println(R.success);
            System.out.println( "The addition of " + num1 + " and " + num2 + " is: " + R.result);
        } catch (MalformedURLException murle) {
            System.out.println();
            System.out.println("MalformedURLException");
            System.out.println(murle);
        } catch (RemoteException re) {
            System.out.println();
            System.out.println("RemoteException");
            System.out.println(re);
        } catch (NotBoundException nbe) {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(nbe);
        } catch (java.lang.ArithmeticException ae) {
            System.out.println();
            System.out.println("java.lang.ArithmeticException");
            System.out.println(ae);
        } catch (Exception e) {
            System.out.println("Trouble: ");
            e.printStackTrace();
        }
    }
}
