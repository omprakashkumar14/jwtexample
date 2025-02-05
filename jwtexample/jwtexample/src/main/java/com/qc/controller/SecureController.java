package com.qc.controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
   import org.springframework.security.oauth2.core.oidc.user.OidcUser;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.RestController;

   @RestController
   public class SecureController {

       @GetMapping("/secure")
       public String secure(@AuthenticationPrincipal OidcUser user) {
           return "Hello, ! This is a secure endpoint.";
       }
   }