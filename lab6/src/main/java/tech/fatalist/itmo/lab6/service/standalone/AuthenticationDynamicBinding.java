package tech.fatalist.itmo.lab6.service.standalone;

import jakarta.ws.rs.container.DynamicFeature;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AuthenticationDynamicBinding implements DynamicFeature {
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
        if (resourceInfo.getResourceMethod().getAnnotation(Protected.class) != null) {
            featureContext.register(AuthFilter.class);
        }
    }
}
