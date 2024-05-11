import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        System.out.println("Iniciando servidor...");
        System.out.println("Esperando cliente...\n");

        final int PORT = 5000;
        final int ADELANTO_SIMULADO = 8000;
        try (
            ServerSocket serverSocket = new ServerSocket(PORT);
            //espera que un cliente se conecre y devuelve un obj socket que representa la conexion
            Socket clienteSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(), true);
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