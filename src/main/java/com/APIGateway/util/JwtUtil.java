package com.APIGateway.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    public static  final String SECRET="fgBDT07Pnjm3QmX/2ndPpiqNc+fZqBAFeXIz3Tbq0BPrONjSLp3nZPjkiyLyAsMp";


    public  void validateToken(final String token){
             Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
            }

            private Key getSignKey() {
                byte[]keyBytes= Decoders.BASE64.decode(SECRET);
                return Keys.hmacShaKeyFor(keyBytes);
            }

}
