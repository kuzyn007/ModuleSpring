package pl.seweryn.user.domain;

import pl.seweryn.user.dto.UserDto;
import pl.seweryn.user.dto.UserRoleDto;

import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
class UserCreator {
    User from(UserDto userDto) {
        requireNonNull(userDto);
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .roles(userDto.getRoles()
                        .stream()
                        .map(e -> userRole(e))
                        .collect(Collectors.toSet())
                )
                .build();
    }

    private UserRole userRole(UserRoleDto userRoleDto) {
        requireNonNull(userRoleDto);
        return UserRole.builder()
                .id(userRoleDto.getId())
                .role(userRoleDto.getRole())
                .description(userRoleDto.getDescription())
                .build();
    }
}
