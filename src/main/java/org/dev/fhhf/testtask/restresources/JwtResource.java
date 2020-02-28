package org.dev.fhhf.testtask.restresources;

import org.dev.fhhf.testtask.security.AuthenticationRequestModel;
import org.dev.fhhf.testtask.security.AuthenticationResponseModel;
import org.dev.fhhf.testtask.security.JwtUtility;
import org.dev.fhhf.testtask.security.TestTaskUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtResource {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtility jwtTokenUtil;
    @Autowired
    private TestTaskUserDetailService userDetailsService;

    @PostMapping("/api/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestModel authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponseModel(jwt));
    }
}
