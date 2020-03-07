package hiber.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

public enum  Role implements GrantedAuthority {
    ADMIN, USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
