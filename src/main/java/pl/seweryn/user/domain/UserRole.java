package pl.seweryn.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pl.seweryn.user.dto.UserRoleDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
class UserRole {

    @Id
    @GeneratedValue
    private Long id;
    private String role;
    private String description;

    UserRoleDto dto() {
        return UserRoleDto.builder()
                .id(id)
                .role(role)
                .description(description)
                .build();
    }
}
