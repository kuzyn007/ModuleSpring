package pl.seweryn.user.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashSet;
import java.util.*;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
@Builder
@Getter
@EqualsAndHashCode
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<UserRoleDto> roles = new HashSet<>();
}
