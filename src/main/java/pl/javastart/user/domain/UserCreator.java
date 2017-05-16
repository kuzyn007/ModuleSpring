package pl.javastart.user.domain;

import pl.javastart.user.dto.UserDto;

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
                .roles(userDto.getRoles().stream()
                    .map(e -> e.))
                .build();
    }
}
