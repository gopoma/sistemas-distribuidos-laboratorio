/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package compra.productos;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author carlos
 */
@WebService(serviceName = "CompraProductos")
public class CompraProductos {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "comprasProductos")
    public String comprasProductos(@WebParam(name = "CantidadPan") int CantidadPan, @WebParam(name = "CantidadQueso") int CantidadQueso, @WebParam(name = "CantidadPlatanos") int CantidadPlatanos, @WebParam(name = "CantidadNaranjas") int CantidadNaranjas){
        //TODO write your implementation code here:
        String mensaje="";
        double total=0;
        if(CantidadPan<1||CantidadQueso<1||CantidadPlatanos<1||CantidadNaranjas<1)
        mensaje+="Lo, siento ingrese una cantidad positiva";
        else{
        mensaje+="\n";
        total+=CantidadPan*0.50;
        mensaje+="Pan: "+CantidadPan + " Unidades--> SubTotal: " +
        CantidadPan*0.50;
        mensaje+="\n // ";
        total+=CantidadQueso*2.50;
        mensaje+="Queso: "+CantidadQueso+" Unidades--> Subtotal: " +
        CantidadQueso*2.50;
        mensaje+="\n // ";
        total+=CantidadPlatanos*0.40;
        mensaje+="Platanos: "+ CantidadPlatanos +" Unidades--> Subtotal: "+
        CantidadPlatanos*0.40;
        mensaje+="\n // ";
        total+=CantidadNaranjas*0.40;
        mensaje+="Naranjas: "+ CantidadNaranjas +" Unidades--> Subtotal: "+
        CantidadNaranjas*0.40;
        mensaje+="\n // "+"El total es: "+total;
        }
        return mensaje;
        
    }
}
