package com.example.demo.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "EMPLOYEE")
@Entity
@Data
@EqualsAndHashCode(of = {"id"})
public class PersistableEmployee implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ID", updatable = false)
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;
}