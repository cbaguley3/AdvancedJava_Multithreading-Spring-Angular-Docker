package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.project.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		// Create MessageService instances for each locale
		MessageService englishService = new MessageService();
		MessageService frenchService = new MessageService();

		// Create threads for each service
		Thread englishThread = new Thread(() -> {
			try {
				String message = englishService.getWelcomeMessages()[0];
				System.out.println(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		Thread frenchThread = new Thread(() -> {
			try {
				String message = frenchService.getWelcomeMessages()[1];
				System.out.println(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		// Start the threads
		englishThread.start();
		frenchThread.start();


	}
}
