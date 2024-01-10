package com.example.legacyservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "stream_types")
public class StreamTypesEntity {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    protected StreamTypesEntity() {}
}
