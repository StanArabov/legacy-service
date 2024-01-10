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
@Table(name="media_items")
public class MediaItemsEntity {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "library_section_id")
    private Integer librarySectionId;

    @Column(name = "section_location_id")
    private Integer sectionLocationId;

    @Column(name = "metadata_item_id")
    private Integer metadataItemId;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @Column(name = "size")
    private Integer size;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "bitrate")
    private Integer bitrate;

    @Column(name = "container")
    private String container;

    @Column(name = "video_codec")
    private String videoCodec;

    @Column(name = "audio_codec")
    private String audioCodec;

    @Column(name = "display_aspect_ratio")
    private Double displayAspectRatio;


    @Column(name = "frames_per_second")
    private Double framesPerSecond;

    @Column(name = "audio_channels")
    private Integer audioChannels;

    @Column(name = "interlaced")
    private Boolean interlaced;

    @Column(name = "source")
    private String source;

    @Column(name = "hints")
    private String hints;

    @Column(name = "display_offset")
    private Integer displayOffset;

    @Column(name = "settings")
    private String settings;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "optimized_for_streaming")
    private Boolean optimizedForStreaming;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "media_analysis_version")
    private Integer mediaAnalysisVersion;

    @Column(name = "sample_aspect_ratio")
    private String sampleAspectRatio;

    @Column(name = "extra_data")
    private String extraData;

    @Column(name = "proxy_type")
    private String proxyType;

    @Column(name = "channel_id")
    private Long channelId;

    @Column(name = "begins_at")
    private LocalDateTime beginsAt;

    @Column(name = "ends_at")
    private LocalDateTime endsAt;

    protected MediaItemsEntity() {}
}
