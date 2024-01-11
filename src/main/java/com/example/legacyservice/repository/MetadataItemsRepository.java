package com.example.legacyservice.repository;

import com.example.legacyservice.entity.MetadataItemsEntity;
import com.example.legacyservice.projection.MovieProjection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MetadataItemsRepository extends JpaRepository<MetadataItemsEntity, Integer> {

    @Query("SELECT " +
            "meta.id as metadataId, " +
            "meta.title AS title, " +
            "meta.summary as description, " +
            "meta.rating as rating, " +
            "meta.originallyAvailableAt as releaseDate, " +
            "mediaParts.duration AS duration, " +
            "meta.year as year, " +
            "meta.metadataType as type, " +
            "meta.index as index, " +
            "GROUP_CONCAT(DISTINCT(CASE WHEN tags.tagType = 4 THEN cast(tags.tag AS char) END)) AS director, " +
            "GROUP_CONCAT(DISTINCT(CASE WHEN tags.tagType = 5 THEN cast(tags.tag AS char) END)) AS writer, " +
            "GROUP_CONCAT(DISTINCT(CASE WHEN tags.tagType = 6 THEN cast(tags.tag AS char) END)) AS stars, " +
            "GROUP_CONCAT(DISTINCT(CASE WHEN tags.tagType = 1 THEN cast(tags.tag AS char) END)) AS genres, " +
            "GROUP_CONCAT(DISTINCT(CASE WHEN mediaStreams.streamTypeId = 1 THEN cast(mediaStreams.language AS char) END)) AS audio, " +
            "GROUP_CONCAT(DISTINCT(CASE WHEN mediaStreams.streamTypeId = 3 THEN cast(mediaStreams.language AS char) END)) AS subtitles " +
            "FROM MetadataItemsEntity meta " +
            "LEFT JOIN MediaItemsEntity mediaItems on meta.id = mediaItems.metadataItemId " +
            "LEFT JOIN MediaPartsEntity mediaParts on mediaItems.id = mediaParts.mediaItemId " +
            "LEFT JOIN MediaStreamsEntity mediaStreams on mediaItems.id = mediaStreams.mediaItemId " +
            "LEFT JOIN TaggingsEntity taggings on meta.id = taggings.metadataItemId " +
            "LEFT JOIN StreamTypesEntity streamTypes on mediaStreams.streamTypeId = streamTypes.id " +
            "LEFT JOIN TagsEntity tags on taggings.tagId = tags.id " +
            "WHERE meta.metadataType in (1) " + // in (1,2) 1 - movies, 2 - series
            "AND meta.librarySectionId NOT IN (9, 10, 13, 14)" +
            "GROUP BY meta.title"
    )
    List<MovieProjection> findMetadataAndMedia(PageRequest pageable);


    @Query("SELECT " +
            "COUNT(DISTINCT meta.title) " +
            "FROM MetadataItemsEntity meta " +
            "LEFT JOIN MediaItemsEntity mediaItems on meta.id = mediaItems.metadataItemId " +
            "LEFT JOIN MediaPartsEntity mediaParts on mediaItems.id = mediaParts.mediaItemId " +
            "LEFT JOIN MediaStreamsEntity mediaStreams on mediaItems.id = mediaStreams.mediaItemId " +
            "LEFT JOIN TaggingsEntity taggings on meta.id = taggings.metadataItemId " +
            "LEFT JOIN StreamTypesEntity streamTypes on mediaStreams.streamTypeId = streamTypes.id " +
            "LEFT JOIN TagsEntity tags on taggings.tagId = tags.id " +
            "WHERE meta.metadataType in (1) " + // in (1,2) 1 - movies, 2 - series
            "AND meta.librarySectionId NOT IN (9, 10, 13, 14)"
    )
    Integer findMoviesCount();

}
