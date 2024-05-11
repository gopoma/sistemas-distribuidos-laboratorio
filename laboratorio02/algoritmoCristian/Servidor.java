import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        final int PORT = 5000;
        final int ADELANTO_SIMULADO = 10000;
        System.out.println("Iniciando servidor...");
        System.out.println("Esperando cliente...\n");

        try (
            ServerSocket serverSocket = new ServerSocket(PORT);
            //espera que un cliente se conecte y devuelve un obj socket que representa la conexion
            Socket clienteSocket = serverSocket.accept();
            //obj para enviar mensajes al cliente
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
            //obj para recibir mensajes del cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            ) {
            
            String inputLine;
            while (true) {
                inputLine = in.readLine();
                if (inputLine.equalsIgnoreCase("Exit")) {
                    System.out.println("Saliendo...");
                    out.println("Apagando servidor...");
                    break;
                }
                out.println(System.currentTimeMillis() + ADELANTO_SIMULADO);
            }
        } catch (Exception e) {
            System.out.println("Tiempo agotado... ");
        }
    }
}