package com.dandelion.springcloud.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 硬编码的方式设置路由
 * 和yml中配置一摸一样
 * 如果多个配置的话写多个bean，这种方式不推荐，推荐使用yml中配置
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLoactor(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_custom",r -> r.path("/guonei")
                                            .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

}
