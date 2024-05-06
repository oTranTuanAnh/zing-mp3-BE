package com.social_music.controller;

import com.social_music.model.JwtResponse;
import com.social_music.model.AppUser;
import com.social_music.service.impl.AppUserServiceImpl;
import com.social_music.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AppUserServiceImpl userService;
    public static Long current_id;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/users/login")
    public ResponseEntity<?> login(@RequestBody AppUser user) {
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AppUser currentUser = userService.findByUsername(user.getUserName());
        JwtResponse a = new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), currentUser.getAvatar(), userDetails.getAuthorities());
        current_id = currentUser.getId();
        return ResponseEntity.ok(a);
    }
    static public Long getId(){
        return current_id;
    }
    @GetMapping("/users")
    public ResponseEntity<Iterable<AppUser>> listUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/users/register")
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user){
        return new ResponseEntity<>(userService.saveNewUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> findUserById(@PathVariable Long id){
        Optional<AppUser> customerOptional = userService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AppUser user = customerOptional.get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping("/users/update/pass/{id}")
    public ResponseEntity<AppUser> updateUserPassword(@PathVariable Long id, @RequestBody AppUser appUser) {
        Optional<AppUser> userOptional = userService.findById(id);
        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AppUser newUser = userOptional.get();

        newUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        newUser.setConfirmPassword(appUser.getConfirmPassword());
        newUser.setOldPassword(appUser.getPassword());
        userService.save(newUser);
        System.out.println("OK!");
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
    @PutMapping("/users/update/infor/{id}")
    public ResponseEntity<AppUser> updateUserProfile(@PathVariable Long id, @RequestBody AppUser appUser) {
//        Optional<AppUser> userOptional = this.userService.findById(id);
//        if (!userOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        AppUser newUser = userOptional.get();
//
//        newUser.setUsername(appUser.getUsername());
//        newUser.setPhoneNumber(appUser.getPhoneNumber());
//        newUser.setAvatar(appUser.getAvatar());
//        newUser.setAddress(appUser.getAddress());
//        newUser.setEmail(appUser.getEmail());
        userService.save(appUser);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }


}
