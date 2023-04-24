package machine;

public interface AuthorisingService {

    //this is an abstract class that other classes will inherit and override
    boolean isAuthorised(String user);
}
