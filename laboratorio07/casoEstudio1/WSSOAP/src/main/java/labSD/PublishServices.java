package labSD;

import javax.xml.ws.Endpoint;
import javax.xml.*;

public class PublishServices {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1516/WS/Users", new SOAPImpl());
	}
}
