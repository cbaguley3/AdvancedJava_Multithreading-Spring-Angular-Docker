package edu.wgu.d387_sample_code.project;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class MessageService {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public String[] getWelcomeMessages() throws IOException, InterruptedException, ExecutionException {
        String[] messages = new String[2];

        List<Future<String>> futures = new ArrayList<>();
        futures.add(executor.submit(() -> getWelcomeMessage("en_US")));
        futures.add(executor.submit(() -> getWelcomeMessage("fr_CA")));

        for (int i = 0; i < messages.length; i++) {
            messages[i] = futures.get(i).get();
        }

//        executor.shutdown(); // <---- causes error
        return messages;
    }

    private String getWelcomeMessage(String locale) throws IOException {
        Properties properties = new Properties();
        String fileName = "welcome_" + locale + ".properties";

        try (InputStream stream = new ClassPathResource(fileName).getInputStream()) {
            properties.load(stream);
            return properties.getProperty("welcome");
        }
    }
}
