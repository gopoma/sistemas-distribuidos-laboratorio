package laboratorio02.algoritmoBerkeley;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client extends Thread{
    private int clientID;
    private long clientTime;
    private SimulatorMonitor sm;
    private final boolean addDelay = true;
    public Client(int clientID,SimulatorMonitor sm){
        this.sm         = sm;
        this.clientID   = clientID;
        this.clientTime = System.nanoTime();
    }
    
    public void run(){
        while(true){ // Clientes permanentemente conectados;
                // Actualizar temp y añadir un retardo específico a cada thread, en este caso (tiempoactual+id (thread+1)*2)
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

                this.clientTime += (this.addDelay) ? (this.clientID+1)*2 : 0;
                System.out.println("Temporización (cliente " + clientID + ") : " + sdf.format(new Date(this.clientTime)));
                this.sm.setDiffTimes(this.clientTime,this.clientID); // Setear las diferencias, si el servidor aun no ha configurado su tiempo, los clientes duermen //
                this.clientTime += this.sm.getSettingTime(this.clientID); // Actualizar reloj del cliente
                System.out.println("Temporización acordada (cliente " + clientID + ") : " + sdf.format(new Date(this.clientTime)));
        }
    }
                 
}