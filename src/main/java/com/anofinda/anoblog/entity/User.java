package com.anofinda.anoblog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author dongyudeng
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User extends AbstractEntity {
    private String username;
    private String password;

    private int status;
    private String avatar;
    private LocalDateTime lastLogin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
