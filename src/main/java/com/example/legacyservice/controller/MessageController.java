package com.example.legacyservice.controller;

import com.example.legacyservice.service.MessageProducerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {

    private final MessageProducerService messageProducerService;

    @GetMapping("/send")
    public String send() {
        messageProducerService.sendMessage("New message 3");
        return "Ok";
    }
}
