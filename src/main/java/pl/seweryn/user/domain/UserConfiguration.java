package pl.seweryn.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
@Configuration
class UserConfiguration {
    @Bean
    UserFacade userFacade(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        UserCreator userCreator = new UserCreator();
        return new UserFacade(userRepository, userRoleRepository,userCreator);
    }
}
