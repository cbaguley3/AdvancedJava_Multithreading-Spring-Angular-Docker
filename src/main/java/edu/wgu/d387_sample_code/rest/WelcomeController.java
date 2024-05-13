package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.project.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@RequestMapping("/welcome")
public class WelcomeController {

    private final MessageService messageService;

    public WelcomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public String[] getWelcomeMessages() throws IOException, InterruptedException, ExecutionException {
        return messageService.getWelcomeMessages();
    }
}

