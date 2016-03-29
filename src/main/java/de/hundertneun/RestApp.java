package de.hundertneun;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/ws")
public class RestApp extends ResourceConfig {
    public RestApp() {
        packages("de.hundertneun.ws");
    }
}