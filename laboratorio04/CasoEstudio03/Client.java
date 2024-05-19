package CasoEstudio03;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class Client {
    public static void main(String[] args) {
        try {
            CreditCardService c = (CreditCardService) Naming.lookup("rmi://localhost:4000/CreditCardService");

            //? Error Handling
            //? int num1 = 20;
            //? int num2 = 5;
            //? System.out.println( "The addition of " + num1 + " and " + num2 + " is: " + c.sum(num1, num2));

            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.println(" ____           _   _   __              _        _____          _      _                  _         ____       __     _ _ _        ");
                System.out.println(" / ___| ___  ___| |_(_) /_/  _ __     __| | ___  |_   _|_ _ _ __(_) ___| |_ __ _ ___    __| | ___   / ___|_ __ /_/  __| (_) |_ ___  ");
                System.out.println("| |  _ / _ \\/ __| __| |/ _ \\| '_ \\   / _` |/ _ \\   | |/ _` | '__| |/ _ \\ __/ _` / __|  / _` |/ _ \\ | |   | '__/ _ \\/ _` | | __/ _ \\ ");
                System.out.println("| |_| |  __/\\__ \\ |_| | (_) | | | | | (_| |  __/   | | (_| | |  | |  __/ || (_| \\__ \\ | (_| |  __/ | |___| | |  __/ (_| | | || (_) |");
                System.out.println(" \\____|\\___||___/\\__|_|\\___/|_| |_|  \\__,_|\\___|   |_|\\__,_|_| _/ |\\___|\\__\\__,_|___/  \\__,_|\\___|  \\____|_|  \\___|\\__,_|_|\\__\\___/ ");
                System.out.println("                                                              |__/                                                                  ");

                System.out.println("1. Leer Registros");
                System.out.println("2. Crear Registro");
                System.out.println("3. Actualizar Registro");
                System.out.println("4. Eliminar Registro");

                System.out.print("Introduzca una opción: ");
                int option = sc.nextInt();

                if(option == 1) {
                    ArrayList<CreditCard> items = (ArrayList<CreditCard>) c.getAll();
                    
                    System.out.println("Cantidad de Registros: " + items.size());

                    //? int id;
                    //? String number;     //? Número de la tarjeta
                    //? String holderDNI;  //? DNI del titular de la tarjeta
                    //? String holderName; //? Nombre del titular de la tarjeta
                    //? double balance;    //? Saldo actual

                    if(items.isEmpty()) {
                        System.out.println("¡No hay registros!");
                    } else {
                        for(int i = 0; i < items.size(); i++) {
                            CreditCard item = items.get(i);
    
                            System.out.println("Registro #" + i + ":");
                            System.out.println("id: " + item.id);
                            System.out.println("Número de la tarjeta: " + item.number);
                            System.out.println("DNI del titular de la tarjeta: " + item.holderDNI);
                            System.out.println("Nombre del titular de la tarjeta: " + item.holderName);
                            System.out.println("Saldo actual: " + item.balance);
                        }
                    }
                } else if(option == 2) {

                } else if(option == 3) {

                } else if(option == 4) {

                } else {
                    System.out.println("¡Opción Inválida!");
                }

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
            }
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
