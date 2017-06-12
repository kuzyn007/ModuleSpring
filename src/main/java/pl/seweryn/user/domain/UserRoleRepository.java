package pl.seweryn.user.domain;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
interface UserRoleRepository {
    UserRole findByRole(String role);
}
