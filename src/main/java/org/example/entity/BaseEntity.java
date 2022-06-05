package com.example.currency.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "create_at", nullable = false)
    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(name = "update_at")
    LocalDateTime updateAt;

    @PreUpdate
    public void preUpdate ()
    {
        this.updateAt = LocalDateTime.now ();
    }
}
