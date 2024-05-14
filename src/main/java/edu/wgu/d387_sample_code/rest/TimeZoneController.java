package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.project.TimeZoneConversion;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@RequestMapping("/welcome")
public class TimeZoneController {
        private final TimeZoneConversion timeZoneConversion;

    public TimeZoneController(TimeZoneConversion timeZoneConversion) {
        this.timeZoneConversion = timeZoneConversion;
    }


        @GetMapping("/timezones")
        public String[] timeZoneConversion() throws IOException, InterruptedException, ExecutionException {
            return timeZoneConversion.convertTimeZones();
        }
}

