package ru.kolemk.otus.dz01;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 */
@ApplicationPath("/otusapp")
@ApplicationScoped
public class App extends Application {
}
