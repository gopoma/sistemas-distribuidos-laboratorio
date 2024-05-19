package creditcards;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class Client {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.codebase", "file:///./CasoEstudio03/");
            System.setProperty("java.rmi.server.useCodebaseOnly", "true");

            Registry registry = LocateRegistry.getRegistry("localhost", 4000);
            CreditCardService c = (CreditCardService) registry.lookup("CreditCardService");
            //? CreditCardService c = (CreditCardService) Naming.lookup("rmi://localhost:4000/CreditCardService");

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

                System.out.println("1. Leer todos los Registros");
                System.out.println("2. Crear Registro");
                System.out.println("3. Leer Registro");
                System.out.println("4. Actualizar Registro");
                System.out.println("5. Eliminar Registro");
                System.out.println("6. Salir");

                System.out.print("Introduzca una opción: ");
                int option = sc.nextInt();
                
                System.out.println();
                System.out.println();

                if(option == 1) {
                    //? Leer todos los Registros
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
    
                            System.out.println("Registro #" + (i + 1) + ":");
                            System.out.println(item);

                            System.out.println();
                            System.out.println();
                        }
                    }
                } else if(option == 2) {
                    //? Crear Registro

                    //? String number;     //? Número de la tarjeta
                    //? String holderDNI;  //? DNI del titular de la tarjeta
                    //? String holderName; //? Nombre del titular de la tarjeta
                    //? double balance;    //? Saldo actual

                    sc.nextLine();

                    System.out.print("Número de la tarjeta: ");
                    String number = sc.nextLine();

                    System.out.print("DNI del titular de la tarjeta: ");
                    String holderDNI = sc.nextLine();

                    System.out.print("Nombre del titular de la tarjeta: ");
                    String holderName = sc.nextLine();

                    System.out.print("Saldo actual: ");
                    double balance = sc.nextDouble();

                    CreditCard item = (CreditCard) c.create(
                        number,
                        holderDNI,
                        holderName,
                        balance
                    );

                    System.out.println();
                    System.out.println();

                    System.out.println("Tarjeta de Crédito creada:");
                    System.out.println(item);
                } else if(option == 3) {
                    //? Leer Registro

                    System.out.print("Id de la Tarjeta de Crédito a Buscar: ");
                    int id = sc.nextInt();

                    CreditCard item = (CreditCard) c.get(id);

                    if(item == null) {
                        System.out.println("¡Registro no Encontrado!");
                    } else {
                        System.out.println("Tarjeta de Crédito con Id " + item.id + ":");
                        System.out.println(item);
                    }
                } else if(option == 4) {
                    //? Actualizar Registro

                    System.out.print("Id de la Tarjeta de Crédito a Actualizar: ");
                    int id = sc.nextInt();

                    CreditCard item = (CreditCard) c.get(id);

                    if(item == null) {
                        System.out.println("¡Registro no Encontrado!");
                    } else {
                        System.out.println("Tarjeta de Crédito con Id " + item.id + ":");
                        System.out.println(item);

                        System.out.println();
                        System.out.println();

                        sc.nextLine();

                        System.out.print("Número de la tarjeta: ");
                        String number = sc.nextLine();

                        System.out.print("DNI del titular de la tarjeta: ");
                        String holderDNI = sc.nextLine();

                        System.out.print("Nombre del titular de la tarjeta: ");
                        String holderName = sc.nextLine();

                        System.out.print("Saldo actual: ");
                        double balance = sc.nextDouble();

                        c.update(
                            item.id,
                            number,
                            holderDNI,
                            holderName,
                            balance
                        );

                        System.out.println("Tarjeta de Crédito Actualizada Satisfactoriamente");
                    }
                } else if(option == 5) {
                    //? Eliminar Registro

                    System.out.print("Id de la Tarjeta de Crédito a Eliminar: ");
                    int id = sc.nextInt();

                    CreditCard item = (CreditCard) c.get(id);

                    if(item == null) {
                        System.out.println("¡Registro no Encontrado!");
                    } else {
                        System.out.println("Registro a Eliminar:");
                        System.out.println(item);

                        System.out.print("Confirmar Eliminación (Y/n): ");
                        String confirmation = sc.next();

                        System.out.println("confirmation: "+confirmation);

                        if(confirmation.toLowerCase().equals("y")) {
                            c.delete(item.id);

                            System.out.println("Tarjeta de Crédito Eliminada Satisfactoriamente");
                        } else if(confirmation.toLowerCase().equals("n")) {
                            System.out.println("Operación [Eliminar] Cancelada");
                        } else {
                            System.out.println("¡Opción Inválida!");
                        }
                    }
                } else if(option == 6) {
                    System.out.println("¡Hasta la próxima!");
                    break;
                } else {
                    System.out.println("¡Opción Inválida!");
                }

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
            }

            sc.close();
        //? } catch (MalformedURLException murle) {
        //?     System.out.println();
        //?     System.out.println("MalformedURLException");
        //?     System.out.println(murle);
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
