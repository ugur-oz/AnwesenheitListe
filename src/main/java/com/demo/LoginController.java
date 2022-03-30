package com.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsersRepository uRepo;

    @GetMapping("/login")
    public String getLogin(){
        Users user = new Users();
        user.setUsername("user");
        String blankPassword = "Passwort1!";

        Users ugur = new Users();

        ugur.setUsername("ugur");
        ugur.setPassword(passwordEncoder.encode("123123"));
        Authorities ugurAuthority = new Authorities();
        ugurAuthority.setUsername("ugur");
        ugurAuthority.setAuthority("ROLE_user");

        user.setPassword(passwordEncoder.encode(blankPassword));
        Authorities userAuthority = new Authorities();
        userAuthority.setUsername("user");
        userAuthority.setAuthority("ROLE_user");
        user.setEnabled(true);

        user.setAuthority(userAuthority);

        uRepo.save(user);
        return "login";
    }

    @GetMapping("/startpage")
    public String getStartpage(){
        return "startpage";
    }

}
