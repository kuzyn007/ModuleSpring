package pl.seweryn.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
@RestController("user")
public class UserEndpoint {
    @PostMapping("/login")
    public Principal login(Principal user) {
        return user;
    }
}
