package com.tw.magixception;


import org.glassfish.jersey.moxy.json.MoxyJsonConfig;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class JsonMoxyConfigurationContextResolver implements ContextResolver<MoxyJsonConfig> {

    private final MoxyJsonConfig config;

    public JsonMoxyConfigurationContextResolver() {
        System.out.println("JsonMoxyConfigurationContextResolver");

        final Map<String, String> namespacePrefixMapper = new HashMap<String, String>();
        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");

        config = new MoxyJsonConfig()
                .setNamespacePrefixMapper(namespacePrefixMapper)
                .setNamespaceSeparator(':')
                .setFormattedOutput(false)
                .setIncludeRoot(false)
                .setMarshalEmptyCollections(false);
    }

    @Override
    public MoxyJsonConfig getContext(Class<?> objectType) {
        return config;
    }

}
