package pl.seweryn.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
