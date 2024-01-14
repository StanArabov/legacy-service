package com.example.legacyservice.controller;

import com.example.legacyservice.service.implementations.MessageProducerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
public class MessageController {

    private final MessageProducerServiceImpl messageProducerService;

    @GetMapping("/send")
    public String send() {
       messageProducerService.sendMessage();
        return "Ok";
    }
}
