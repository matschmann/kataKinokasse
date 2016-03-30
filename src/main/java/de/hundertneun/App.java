package de.hundertneun;

import de.hundertneun.webservice.MovieWebservice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);
    public static final int DEFAUL_PORT = 8081;


    public static void main(String[] args) {
        
        int port = getPortNumber(args);
        try {
            createServer(port);
            logger.info("----->Started server on port " + port);
        } catch (Exception e) {
            logger.error("Error in Application", e);
        }
    }

    private static int getPortNumber(String[] arg) {
        if (arg.length == 0) {
            return DEFAUL_PORT;
        }
        
        try {
            return Integer.parseInt(arg[0]);
        } catch (NumberFormatException e) {
            logger.error(arg[0] + " is not a valid port number, usign default port " + DEFAUL_PORT);
            return DEFAUL_PORT;
        }
    }

    private static void createServer(int port) throws IOException, InterruptedException {
        URI baseUri = URI.create("http://localhost:" + port);

        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, createApp(), false);
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
        server.start();
        Thread.currentThread().join();
    }

    public static ResourceConfig createApp() {
        return new ResourceConfig(){
            {
                registerClasses(MovieWebservice.class);
            }
        };
    }
}