package com.tw.magixception;


import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

public class EncryptionDynamicFeature implements DynamicFeature {
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        System.out.println("EncryptionDynamicFeature");
        context.register(DecodeRequestInterceptor.class);
        context.register(EncodeRequestInterceptor.class);
    }
}
