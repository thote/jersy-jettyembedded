package com.tw.magixception;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ext.ContextResolver;
import java.util.HashMap;
import java.util.Map;

import static com.sun.jersey.api.core.PackagesResourceConfig.PROPERTY_PACKAGES;
import static com.sun.jersey.api.core.ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS;
import static com.sun.jersey.api.core.ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS;
import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) throws Exception {
        Server s = new Server(8183);
        ServletContextHandler sch = new ServletContextHandler(s, "/");
        sch.addServlet(getServlet(), "/*");

        try {
            s.start();
            synchronized (s) {
                s.wait();
            }
        } catch(Exception e) {
            System.out.println("exception thrown : " + e.getMessage());
        }
    }


    private static ServletHolder getServlet() {
        return new ServletHolder(new ServletContainer(getPackageResourceConfig()));
    }


    private static PackagesResourceConfig getPackageResourceConfig() {
        HashMap<String, Object> config = new HashMap<>();
        config.put(PROPERTY_PACKAGES, "com.tw.magixception");
        config.put(PROPERTY_CONTAINER_REQUEST_FILTERS, asList(UrlDecodeFilter.class));
        config.put(PROPERTY_CONTAINER_RESPONSE_FILTERS, asList(UrlDecodeFilter.class));

        return new PackagesResourceConfig(config);
    }

    public static ResourceConfig createApp() {
        return new ResourceConfig()
                .packages("com.tw.magixception")
                .register(createMoxyJsonResolver());
    }

    public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
        Map<String, String> namespacePrefixMapper = new HashMap<String, String>(1);
        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');
        return moxyJsonConfig.resolver();
    }

}
