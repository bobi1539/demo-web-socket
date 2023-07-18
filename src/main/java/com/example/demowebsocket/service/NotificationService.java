package com.example.demowebsocket.service;

import com.example.demowebsocket.dto.request.NotificationRequest;
import com.example.demowebsocket.dto.response.NotificationResponse;

public interface NotificationService {
    NotificationResponse create(NotificationRequest request);
}
