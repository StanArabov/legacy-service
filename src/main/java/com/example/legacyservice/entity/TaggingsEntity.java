package com.example.legacyservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="taggings")
public class TaggingsEntity {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "metadata_item_id")
    private Integer metadataItemId;

    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "\"index\"")
    private Integer index;

    @Column(name = "text")
    private String text;

    @Column(name = "time_offset")
    private Integer timeOffset;

    @Column(name = "end_time_offset")
    private Integer endTimeOffset;

    @Column(name = "thumb_url")
    private String thumbUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "extra_data")
    private String extraData;

    protected TaggingsEntity() {}
}
