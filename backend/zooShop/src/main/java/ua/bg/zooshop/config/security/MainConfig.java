package ua.bg.zooshop.config.security;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
@RequiredArgsConstructor
public class MainConfig{

    @Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

        @Bean
        public ModelMapper modelMapper() {
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration()
                    .setMatchingStrategy(MatchingStrategies.STRICT)
                    .setFieldMatchingEnabled(true)
                    .setSkipNullEnabled(true)
                    .setFieldAccessLevel(PRIVATE);
            return mapper;
        }
}
