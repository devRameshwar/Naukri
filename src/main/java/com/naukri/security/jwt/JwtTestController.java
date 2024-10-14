package com.naukri.security.jwt;

import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/jwt")
public class JwtTestController {

    @Autowired
    private JwtGenerator jwtGenerator;

    @RequestMapping(path = "/getToken/{userName}", method = RequestMethod.GET)
    public ResponseEntity<String> getToken(@PathVariable String userName) {
        return ResponseEntity.ok(jwtGenerator.generateJwtToken(userName));
    }

    @RequestMapping(path = "/getUserName",method = RequestMethod.GET)
    public ResponseEntity<String> getUserNameToToken(@RequestHeader(name = "Lock-Token",required = true) String token) {
        return ResponseEntity.ok(jwtGenerator.getUserNameFromToken(token));
    }

    @RequestMapping(path = "/check",method = RequestMethod.GET)
    public ResponseEntity<Boolean> CheckTokenValidation(@RequestHeader(name = "Lock-Token",required = true) String token){
      return ResponseEntity.ok(jwtGenerator.isTokenExpired(token)) ;
    }

    @RequestMapping(path = "check/{userName}",method = RequestMethod.GET)
    public ResponseEntity<Boolean> validToken(@PathVariable String userName, @RequestHeader(name = "Lock-Token",required = true)String token){
        return ResponseEntity.ok(jwtGenerator.validToken(userName,token));
    }

}
