package pers.anofinda.anoblog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author dongyudeng
 */
@Getter
@Setter
@Entity
@Table(name = "tag")
public class Tag extends AbstractEntity {
    @Column(name = "tag_name", nullable = false, unique = true)
    private String tagName;
}
