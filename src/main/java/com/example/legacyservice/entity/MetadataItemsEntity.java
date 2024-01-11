package com.example.legacyservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="metadata_items")
public class MetadataItemsEntity {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="library_section_id")
    private Integer librarySectionId;

    @Column(name="parent_id")
    private Integer parentId;

    @Column(name="metadata_type")
    private Integer metadataType;

    @Column(name="guid")
    private String guid;

    @Column(name="media_item_count")
    private Integer mediaItemCount;

    @Column(name = "title")
    private String title;

    @Column(name = "title_sort")
    private String titleSort;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "studio")
    private String studio;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "rating_count")
    private Integer ratingCount;

    @Column(name = "tagline")
    private String tagline;

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "trivia")
    private String trivia;

    @Column(name = "quotes")
    private String quotes;

    @Column(name = "content_rating")
    private String contentRating;

    @Column(name = "content_rating_age")
    private Integer contentRatingAge;

    @Column(name = "\"index\"")
    private Integer index;

    @Column(name = "absolute_index")
    private Integer absoluteIndex;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "user_thumb_url")
    private String userThumbUrl;

    @Column(name = "user_art_url")
    private String userArtUrl;

    @Column(name = "user_banner_url")
    private String userBannerUrl;

    @Column(name = "user_music_url")
    private String  userMusicUrl;

    @Column(name = "user_fields")
    private String userFields;

    @Column(name = "tags_genre")
    private String tagsGenre;

    @Column(name = "tags_collection")
    private String tagsCollection;

    @Column(name = "tags_director")
    private String tagsDirector;

    @Column(name = "tags_writer")
    private String tagsWriter;

    @Column(name = "tags_star")
    private String tagsStar;

    @Column(name = "originally_available_at")
    private LocalDateTime originallyAvailableAt;

    @Column(name = "available_at")
    private LocalDateTime availableAt;

    @Column(name = "expires_at")
    private LocalDateTime expiresaAt;

    @Column(name = "refreshed_at")
    private LocalDateTime refreshedAt;

    @Column(name = "year")
    private Integer year;

    @Column(name = "added_at")
    private LocalDateTime addedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "tags_country")
    private String tagsCountry;

    @Column(name = "extra_data")
    private String extraData;

    @Column(name = "hash")
    private String hash;

    @Column(name = "audience_rating")
    private Double audienceRating;

    @Column(name = "changed_at")
    private Integer changedAt;

    @Column(name = "resources_changed_at")
    private Integer resourcesChangedAt;

}
