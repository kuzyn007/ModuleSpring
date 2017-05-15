package pl.javastart.user.domain;

/**
 * Created by Seweryn Adamczyk on 2017-05-15.
 */
enum UserType {
    ROLE_USER("ROLE_USER"),
    ROLE_MANAGER("ROLE_MANAGER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private String userType;

    UserType(String type) {
        this.userType = type;
    }


}
