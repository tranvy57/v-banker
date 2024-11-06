package edu.iuh.fit.v_banker.config;

import edu.iuh.fit.v_banker.entities.Role;
import edu.iuh.fit.v_banker.entities.User;
import edu.iuh.fit.v_banker.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Configuration
@RequiredArgsConstructor //Khôgn cần khởi tạo contructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner (UserRepository userRepository){
        return args -> {
            if( userRepository.findByEmail("admin").isEmpty()){

                User user = User.builder()
                        .email("admin")
                        .password(passwordEncoder.encode("admin"))
                        .role(Role.ROLE_ADMIN)
                        .build();

                userRepository.save(user);
                log.warn("admin user has been created with password: admin, please change it");
            }
        };
    }
}
