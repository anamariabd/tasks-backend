package com.homework.homework.entities;

import com.homework.homework.enums.StateType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="tarea")
public class Task {
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false,
            length = 10)
    @Enumerated(EnumType.STRING)
    private StateType status;

    @Column(name = "created_at", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

}
