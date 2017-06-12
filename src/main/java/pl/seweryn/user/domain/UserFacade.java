package pl.seweryn.user.domain;

import pl.seweryn.user.dto.UserDto;
import pl.seweryn.user.dto.UserRoleDto;

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
        UserRoleDto userRole = defaultRole.dto();
        userDto.getRoles().add(userRole);

        User user = userCreator.from(userDto);
        user = userRepository.save(user);

        return user.dto();
    }
}
