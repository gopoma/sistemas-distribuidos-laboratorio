/**
 * SOAPI.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package labSD;

public interface SOAPI extends java.rmi.Remote {
    public labSD.User[] getUsers() throws java.rmi.RemoteException;
    public void addUser(labSD.User arg0) throws java.rmi.RemoteException;
}
