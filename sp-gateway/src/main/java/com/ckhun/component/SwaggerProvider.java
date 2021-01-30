package com.ckhun.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : Kunhong Chan
 * @date : Created in 19:54 2021/1/30
 * @description :
 * @since : 1.0.0
 */

@Component
public class SwaggerProvider implements SwaggerResourcesProvider {

    private static final String SWAGGER2URL = "/v2/api-docs";


    private final RouteLocator routeLocator;

    @Value("${spring.application.name}")
    private String appName;

    public SwaggerProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> route = new ArrayList<>();
        routeLocator.getRoutes().filter(router -> router.getUri().getHost() != null)
                .filter(router -> !appName.equals(router.getUri().getHost()))
                .subscribe(router -> route.add(router.getUri().getHost()));

        Set<String> deal = new HashSet<>();
        route.forEach(instance -> {
            String url = "/" + instance + SWAGGER2URL;
            if (!deal.contains(url)) {
                deal.add((url));
                SwaggerResource swaggerResource = new SwaggerResource();
                swaggerResource.setUrl(url);
                swaggerResource.setName(instance);
                resources.add(swaggerResource);
            }
        });
        return resources;
    }
}
