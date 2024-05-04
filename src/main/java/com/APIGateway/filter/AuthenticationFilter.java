package com.APIGateway.filter;

import com.APIGateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;

import org.springframework.stereotype.Component;


@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory< AuthenticationFilter.Config> {

    @Autowired
    private  RouterValidator validator;

    @Autowired
    private  JwtUtil jwtUtil;


    public  AuthenticationFilter(){
        super(Config.class);
    }




    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {

            if(validator.isSecure.test(exchange.getRequest())){
                System.out.println("gate way work ");
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Missing authorization header");
                }
                String authHeader= exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

                 if (authHeader!=null&&authHeader.startsWith("Bearer ")){
                     authHeader=authHeader.substring(7);

                 }
                 try {

                     jwtUtil.validateToken(authHeader);

                 }catch (Exception e){

                     System.out.println("Invalid");
                     throw  new RuntimeException("Unauthorized access to application");
                 }
            }
            return chain.filter(exchange);
        }));
    }

    public  static  class Config{

    }

}




