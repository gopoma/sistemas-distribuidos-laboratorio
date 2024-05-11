import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
    public static void main(String[] args) {
        final int PORT = 5000;
        final String SERVER = "localhost";
        try (
            //se conecta al servidor localhost en el puerto 5000
            Socket socket = new Socket(SERVER, PORT);
            //Via para comunicarse con el servdor
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //via para recibir mensajes del servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            Long T0, Ts, T1, TSinc;
            System.out.println("Iniciando Cliente...");
            T0 = System.currentTimeMillis(); //captura de T0
            out.println(T0); //envio del tiempo actual al servidor
            Ts = Long.parseLong(in.readLine()); //lectura del tiempo del servidor

            T1 = System.currentTimeMillis(); //captura del tiempo de recepcion T1
            TSinc = Ts + (T1 - T0)/2; //calculo del nuevo tiempo 
            DateFormat horaformat = new SimpleDateFormat("HH:mm:ss:SSS");

            System.out.println("Tiempo del cliente: " + horaformat.format(new Date(T1)));
            System.out.println("Tiempo del servidor: " + horaformat.format(new Date(Ts)));
            System.out.println("Tiempo del cliente sincronizado: " + horaformat.format(new Date(TSinc)));
            System.out.println("\nEl cliente se ha detenido...");

            
        } catch (Exception e) {
            System.out.println("Tiempo agotado...");
        }
    }
}