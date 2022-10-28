package ua.bg.zooshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncoderPassword {

     PasswordEncoder passwordEncoder;


    public String EncodingPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean EqualsPassword(String oldPassword,String newPassword){
        return passwordEncoder.matches(oldPassword,newPassword);
    }
}
