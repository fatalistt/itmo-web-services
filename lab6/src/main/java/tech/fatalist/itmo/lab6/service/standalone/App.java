package tech.fatalist.itmo.lab6.service.standalone;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class App {
    public static void main(String[] args) throws IOException {
        final var url = "http://0.0.0.0:8080/rest/";
        final var resourceConfig = new ResourceConfig().packages(App.class.getPackageName());
        var server = GrizzlyHttpServerFactory.createHttpServer(URI.create(url), resourceConfig);
        //noinspection ResultOfMethodCallIgnored
        System.in.read();
        server.shutdownNow();
    }
}
