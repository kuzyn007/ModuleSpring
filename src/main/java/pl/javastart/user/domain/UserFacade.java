package pl.javastart.user.domain;

import pl.javastart.user.dto.UserDto;
import pl.javastart.user.dto.UserRoleDto;

import static java.util.Objects.requireNonNull;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
public class UserFacade {
    private static final String DEFAULT_ROLE = "ROLE_USER";

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private UserCreator userCreator;

    public UserFacade(UserRepository userRepository, UserRoleRepository userRoleRepository, UserCreator userCreator)  {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.userCreator = userCreator;
    }

    public UserDto add(UserDto userDto) {
        requireNonNull(userDto);
        UserRole defaultRole = userRoleRepository.findByRole(DEFAULT_ROLE);
        User user = userCreator.fromUser(userDto);


        user = userRepository
    }
}
