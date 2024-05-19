package CasoEstudio03;

import java.io.Serializable;

public class ServerResponse implements Serializable {
    public boolean success;
    public int result;
    
    public ServerResponse() {}
    public ServerResponse(boolean s, int r) {
        this.success = s;
        this.result = r;
    }
}
