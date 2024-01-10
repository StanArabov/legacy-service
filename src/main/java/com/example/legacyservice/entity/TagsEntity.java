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
@Table(name = "tags")
public class TagsEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "metadata_item_id")
    private Integer metadataItemId;

    @Column(name = "tag")
    private String tag;

    @Column(name = "tag_type")
    private Integer tagType;

    @Column(name = "user_thumb_url")
    private String userThumbUrl;

    @Column(name = "user_art_url")
    private String userArtUrl;

    @Column(name = "user_music_url")
    private String userMusicUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "tag_value")
    private Integer tagValue;

    @Column(name = "extra_data")
    private String extraData;

    @Column(name = "\"key\"")
    private String key;

    protected TagsEntity() {}
}
