package tech.fatalist.itmo.lab4.service.ee;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("rest")
public class RSApplication extends Application {
    public RSApplication() {
        super();
    }
}
