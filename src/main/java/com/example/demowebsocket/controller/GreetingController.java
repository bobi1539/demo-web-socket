package com.example.demowebsocket.controller;

import com.example.demowebsocket.dto.Greeting;
import com.example.demowebsocket.dto.HelloMessage;
import com.example.demowebsocket.dto.request.NotificationRequest;
import com.example.demowebsocket.dto.response.NotificationResponse;
import com.example.demowebsocket.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage helloMessage) throws InterruptedException {
        Thread.sleep(1000);
        return Greeting.builder()
                .content("Hello " + HtmlUtils.htmlEscape(helloMessage.getName()) + " !")
                .build();
    }
}
