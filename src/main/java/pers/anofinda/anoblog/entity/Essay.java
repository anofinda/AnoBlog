package pers.anofinda.anoblog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author dongyudeng
 */
@Setter
@Getter
@Entity
@Table(name = "essay")
public class Essay extends AbstractEntity {
    @Column(name = "tittle", nullable = false, unique = true)
    private String tittle;
    @Column(name = "content")
    private String content;
    @Column(name = "tag_name", nullable = false,unique = true)
    private String tagName;
    @Column(name = "sticky", nullable = false)
    private Integer sticky;
    @Column(name = "visible", nullable = false)
    private Boolean visible;
    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
