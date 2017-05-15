package pl.javastart.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import pl.javastart.user.dto.UserDto;
import pl.javastart.user.dto.UserRoleDto;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    UserDto dto() {
        return UserDto.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .roles(roles.stream()
                        .map(userRole -> userRole.dto())
                        .collect(Collectors.toSet()))
                .build();
    }
}
