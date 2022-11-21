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
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false,unique = true)
    private Long id;

    @Column(name = "created_time", nullable = false, updatable = false)
    private LocalDateTime createdTime;
}
