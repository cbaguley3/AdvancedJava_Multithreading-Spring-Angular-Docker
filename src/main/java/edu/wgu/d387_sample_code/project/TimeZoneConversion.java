package edu.wgu.d387_sample_code.project;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@Service
public class TimeZoneConversion {

    private String[] timeZones = new String[3];

    public String[] convertTimeZones() {

        ZoneId zoneId = ZoneId.systemDefault();

        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Denver");
        ZoneId zUniversal = ZoneId.of("UTC");

        // Get current LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now().withHour(12).withMinute(0).withSecond(0).withNano(0);
        System.out.println("local time " + localDateTime);

        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);

        // Convert to Mountain Time
        ZonedDateTime zonedDateTimeMountain = localDateTime.atZone(zoneId).withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain = zonedDateTimeMountain.toLocalDateTime();
        System.out.println("Mountain Time "+localDateTimeMountain.toString());
        timeZones[1] = localDateTimeMountain.format(DateTimeFormatter.ofPattern("HH:mm")) + " - MT";

        // Convert to Eastern Time
        ZonedDateTime zonedDateTimeEastern = localDateTime.atZone(zoneId).withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern = zonedDateTimeEastern.toLocalDateTime();
        System.out.println("Eastern Time "+localDateTimeEastern.toString());
        timeZones[0] = localDateTimeEastern.format(DateTimeFormatter.ofPattern("HH:mm")) + " - ET";

        // Convert to Universal Time
        ZonedDateTime zonedDateTimeUniversal = localDateTime.atZone(zoneId).withZoneSameInstant(zUniversal);
        LocalDateTime localDateTimeUniversal = zonedDateTimeUniversal.toLocalDateTime();
        System.out.println("Universal Time "+localDateTimeUniversal.toString());
        timeZones[2] = localDateTimeUniversal.format(DateTimeFormatter.ofPattern("HH:mm")) + " - UTC";

        return timeZones;
    }
}

