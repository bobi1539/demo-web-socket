package com.example.demowebsocket.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NotificationResponse {
    private Long id;
    private String message;
}
