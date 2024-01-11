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
@Table(name = "media_streams")
public class MediaStreamsEntity {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "stream_type_id")
    private Integer streamTypeId;

    @Column(name = "media_item_id")
    private Integer mediaItemId;

    @Column(name = "url")
    private String url;

    @Column(name = "codec")
    private String codec;

    @Column(name = "language")
    private String language;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "\"index\"")
    private Integer index;

    @Column(name = "media_part_id")
    private Integer mediaPartId;

    @Column(name = "channels")
    private Integer channels;

    @Column(name = "bitrate")
    private Integer bitrate;

    @Column(name = "url_index")
    private Integer urlIndex;

    @Column(name = "\"default\"")
    private Boolean defaultValue;

    @Column(name = "forced")
    private Boolean forced;

    @Column(name = "extraData")
    private String extraData;

}
