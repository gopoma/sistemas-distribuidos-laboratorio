
import java.rmi.RemoteException;
import java.util.Arrays;

import javax.xml.rpc.ServiceException;

import labSD.SOAPI;
import labSD.SOAPImplService;
import labSD.SOAPImplServiceLocator;
import labSD.User;

public class UserClient {
	public static void main(String[] args) throws ServiceException, RemoteException {
		SOAPImplServiceLocator locator = new SOAPImplServiceLocator();
		SOAPI userService = locator.getSOAPImplPort();
		
		//se muestra la lista de usuario
		System.out.println("Lista de usuarios: ");
		System.out.println(Arrays.toString(userService.getUsers()));
		
		//se anade nuevo usuario
		userService.addUser(new User("Pablo", "Ruiz"));
		
		//Se muestra la lista de usuarios
		System.out.println("Lista de usuario");
		System.out.println(Arrays.toString(userService.getUsers()));
	}
}
