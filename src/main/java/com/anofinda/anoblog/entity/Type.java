package com.anofinda.anoblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author dongyudeng
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "type")
public class Type extends AbstractEntity {
    private String name;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "type")
    private Set<Blog> blogs;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Type type = (Type) o;
        return id != null && Objects.equals(id, type.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
