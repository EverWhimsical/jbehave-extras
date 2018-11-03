package com.everwhimsical.jbehave.internal;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.concurrent.atomic.AtomicLong;

public final class Commons {

    private static final AtomicLong LAST_TIME_MS = new AtomicLong();

    private Commons() {

    }

    /**
     * Calculates the time duration between given two {@link ZonedDateTime}s
     *
     * @param startTime, Start time in the {@link ZonedDateTime} format
     * @param endTime, End time in the {@link ZonedDateTime} format
     * @return The duration string in the format of hh:mm:ss
     */
    public static String calculateDuration(ZonedDateTime startTime, ZonedDateTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        long durationInSeconds = duration.getSeconds();

        return String
            .format("%02dh:%02dm:%02ds", durationInSeconds / 3600, (durationInSeconds % 3600) / 60,
                (durationInSeconds % 60));
    }
}
