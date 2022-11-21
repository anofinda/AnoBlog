package pers.anofinda.anoblog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "sticky", nullable = false)
    private Integer sticky;
    @Column(name = "visible", nullable = false)
    private Boolean visible;
    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
