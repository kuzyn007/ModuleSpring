package pl.seweryn.user.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
@Builder
@Getter
@EqualsAndHashCode
public class UserRoleDto {
    private Long id;
    private String role;
    private String description;
}
