package com.example.demowebsocket.service.impl;

import com.example.demowebsocket.dto.request.NotificationRequest;
import com.example.demowebsocket.dto.response.NotificationResponse;
import com.example.demowebsocket.entity.Notification;
import com.example.demowebsocket.repository.NotificationRepository;
import com.example.demowebsocket.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository notificationRepository;

    @Override
    public NotificationResponse create(NotificationRequest request) {
        Notification notification = Notification.builder()
                .message(request.getMessage())
                .build();
        Notification notificationSaved = notificationRepository.save(notification);
        return NotificationResponse.builder()
                .id(notificationSaved.getId())
                .message(notificationSaved.getMessage())
                .build();
    }
}
