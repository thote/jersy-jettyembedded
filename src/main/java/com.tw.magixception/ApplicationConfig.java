package com.tw.magixception;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ApplicationPath("/*")
public class ApplicationConfig extends Application {

    public ApplicationConfig() {
        System.out.println("ApplicationConfig");
    }

    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> resources = new java.util.HashSet<>();

        System.out.println("REST configuration starting: getClasses()");

        resources.add(org.glassfish.jersey.moxy.json.MoxyJsonFeature.class);
        resources.add(JsonMoxyConfigurationContextResolver.class);
        resources.add(MyResource.class);

        System.out.println("REST configuration ended successfully.");

        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        System.out.println("getSingletons");
        return Collections.emptySet();
    }

    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();

        //in Jersey WADL generation is enabled by default, but we don't
        //want to expose too much information about our apis.
        //therefore we want to disable wadl (http://localhost:8080/service/application.wadl should return http 404)
        //see https://jersey.java.net/nonav/documentation/latest/user-guide.html#d0e9020 for details
        properties.put("jersey.config.server.wadl.disableWadl", true);

        //we could also use something like this instead of adding each of our resources
        //explicitly in getClasses():
        //properties.put("jersey.config.server.provider.packages", "com.nabisoft.tutorials.mavenstruts.service");


        return properties;
    }
}