package com.anofinda.anoblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
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
@Table(name = "blog")
public class Blog extends AbstractEntity {
    private String tittle;
    private String content;
    private int sticky;
    private boolean visible;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private Type type;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(targetEntity = Tag.class, cascade = CascadeType.ALL)
    @JoinTable(name = "blog_tag",
            joinColumns = {@JoinColumn(name = "blog_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id", referencedColumnName = "id")})
    private Set<Tag> tags;
    private LocalDateTime lastUpdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Blog blog = (Blog) o;
        return id != null && Objects.equals(id, blog.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
