package com.example.legacyservice.util;

public final class Constants {
    public static final int METADATA_TYPE_MOVIE = 1;
    public static final int METADATA_TYPE_TV_SERIES = 2;

    public static final String MOVIE_QUEUE_ROUTING_KEY = "movie";

    public static final String TV_SERIES_ROUTING_KEY = "tv-series";

    public static final String EXCHANGE = "plex.direct";

    public static final String MOVIE_QUEUE = "plex-movies-queue";

    public static final String TV_SERIES_QUEUE = "plex-tv-series-queue";

    public static final int MOVIES_PAGE_SIZE = 2000;
    public static final int TV_SERIES_PAGE_SIZE = 5;
}
