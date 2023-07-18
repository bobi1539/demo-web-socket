package com.example.demowebsocket.repository;

import com.example.demowebsocket.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
