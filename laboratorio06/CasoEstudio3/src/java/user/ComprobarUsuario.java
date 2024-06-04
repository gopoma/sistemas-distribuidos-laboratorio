/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author anthony
 */

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName="ComprobarUsuario")
public class ComprobarUsuario {
    @WebMethod (operationName="comprobar")
    public boolean Comprobar(@WebParam(name="usuario") String user, @WebParam(name="contrasenia") String contra){
        String userTest = "Nat";
        String pass = "12345";
        if (user.equals(userTest) && contra.equals("12345"))
            return true;
        
        return false;
    }
}
