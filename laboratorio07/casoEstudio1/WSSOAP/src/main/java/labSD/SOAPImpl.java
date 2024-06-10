package labSD;

import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface = "labSD.SOAPI")
public class SOAPImpl implements SOAPI{
	@Override
	public List<User> getUsers() {
		return User.getUsers();
	}
	@Override
	public void addUser(User user) {
		User.getUsers().add(user);
	}
}