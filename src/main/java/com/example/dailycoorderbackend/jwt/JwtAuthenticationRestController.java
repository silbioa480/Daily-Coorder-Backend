package com.example.dailycoorderbackend.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Exposes all the URLs related to JWT Authentication.
@RestController
public class JwtAuthenticationRestController {

  @Value("${jwt.http.request.header}")
  private String tokenHeader;

  @Value("${token.cookie.name}")
  private String tokenCookieName;

  @Value("${token.cookie.expiration.in.seconds}")
  private int tokenCookieExpirationTime;

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private JwtTokenUtil jwtTokenUtil;
  @Autowired
  private UserDetailsService jwtInMemoryUserDetailsService;

  @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest,
                                                     HttpServletResponse response) throws AuthenticationException {
    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    final UserDetails userDetails = jwtInMemoryUserDetailsService
      .loadUserByUsername(authenticationRequest.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);
    addTokenToCookie(response, token);
    Map<String, Object> result = new HashMap<>();
    result.put("message", "Authentication success");
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  private void addTokenToCookie(HttpServletResponse response, String token) {
    Cookie tokenCookie = new Cookie(tokenCookieName, token);
    tokenCookie.setMaxAge(tokenCookieExpirationTime);
    response.addCookie(tokenCookie);
  }

  @ExceptionHandler({AuthenticationException.class})
  public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
  }

  private void authenticate(String username, String password) {
    Objects.requireNonNull(username);
    Objects.requireNonNull(password);
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new AuthenticationException("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new AuthenticationException("INVALID_CREDENTIALS", e);
    }
  }
}