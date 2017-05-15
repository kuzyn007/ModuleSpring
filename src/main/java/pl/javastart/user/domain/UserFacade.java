package pl.javastart.user.domain;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
public class UserFacade {
    private static final String DEFAULT_ROLE = UserType.ROLE_USER.name();
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;


}
