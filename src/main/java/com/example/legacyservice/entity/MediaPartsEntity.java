package com.example.legacyservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "media_parts")
public class MediaPartsEntity {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "media_item_id")
    private Integer mediaItemId;

    @Column(name = "directory_id")
    private Integer directoryId;

    @Column(name = "hash")
    private String hash;

    @Column(name = "open_subtitle_hash")
    private String openSubtitleHash;

    @Column(name = "file")
    private String file;

    @Column(name = "\"index\"")
    private Integer index;

    @Column(name = "size")
    private Integer size;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


    @Column(name = "extra_data")
    private String extraData;

}
