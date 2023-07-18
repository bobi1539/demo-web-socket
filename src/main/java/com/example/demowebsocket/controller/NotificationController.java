package com.example.demowebsocket.controller;

import com.example.demowebsocket.dto.Greeting;
import com.example.demowebsocket.dto.HelloMessage;
import com.example.demowebsocket.dto.request.NotificationRequest;
import com.example.demowebsocket.dto.response.NotificationResponse;
import com.example.demowebsocket.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RestController
@RequestMapping("/api/notification")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NotificationController {
    private NotificationService notificationService;
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("hello");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody NotificationRequest request) throws InterruptedException {
        // save notification to db
        NotificationResponse notificationResponse = notificationService.create(request);

        // publish notification to client that subscribe the endpoint
        simpMessagingTemplate.convertAndSend("/topic/greetings", Greeting.builder().content(request.getMessage()).build());
        return ResponseEntity.ok(notificationResponse);
    }
}
