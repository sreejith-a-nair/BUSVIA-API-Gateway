package com.APIGateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    public  static  final List<String> openEndPoints =List.of(
            "/auth/**",
            "/auth/token",
            "/user/signup",
            "/user/more-details",
            "/user/getAllAuthorityByRole",
            "/eureka"
    );
    public Predicate<ServerHttpRequest> isSecure =
            request -> openEndPoints
                    .stream()
                    .noneMatch(uri->request.getURI().getPath().contains(uri));

}
