package com.tw.magixception;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.HashMap;

import static com.sun.jersey.api.core.PackagesResourceConfig.PROPERTY_PACKAGES;
import static com.sun.jersey.api.core.ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS;
import static com.sun.jersey.api.core.ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS;
import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) throws Exception {
        Server s = new Server(8183);
        ServletContextHandler sch = new ServletContextHandler(s, "/");
        sch.addServlet(getServlet(), "/*");

        s.start();
        synchronized (s) {
            s.wait();
        }
    }

    private static ServletHolder getServlet() {
        return new ServletHolder(new ServletContainer(getPackageResourceConfig()));
    }

    private static PackagesResourceConfig getPackageResourceConfig() {
        HashMap<String, Object> config = new HashMap<>();
        config.put(PROPERTY_PACKAGES, "com.tw.magixception");
        config.put(PROPERTY_CONTAINER_REQUEST_FILTERS, asList(ExceptionFilter.class));
        config.put(PROPERTY_CONTAINER_RESPONSE_FILTERS, asList(ExceptionFilter.class));

        return new PackagesResourceConfig(config);
    }
}
